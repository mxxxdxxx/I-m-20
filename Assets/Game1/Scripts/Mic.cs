using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI; // UI ��� ����ϱ� ���� �߰�
using UnityEngine.Networking;
using System.Text;

[System.Serializable] // ����ȭ
public class GameData // ������ �����ϴ� Ŭ�����Դϴ�. �Ʒ� �������� �����͸� �����ϱ� ���� ���.
{
    public float bt_length; // �Ҹ� ����
    public float bt_pitch1; // �Ҹ� ������ = ����(0.5�� ������  bt_pitch1~bt_pitch6���� ����)
    public float bt_pitch2;
    public float bt_pitch3;
    public float bt_pitch4;
    public float bt_pitch5;
    public float bt_pitch6;
    public int bt_times;
    public int bt_success;
}

public class Mic : MonoBehaviour
{
    AudioSource aud;

    public GameObject sphereObjectPrefab; // ������ sphere object�� ������
    public Transform[] sphereSpawnPoints; // ���ο� object�� ������ ��ġ
    public Text timeText; // UI Text ���۷���
    public Text statusText; // ���� ���� ���� text
    public BalloonSliderController balloonSliderController; // �����̴� ��Ʈ�ѷ� ���� �߰�
    public Text attemptsText; // ���� �õ� Ƚ���� ǥ���� UI Text ����
    public CircleTimer circleTimer; // CircleTimer ������ ���� public ���� �߰�

    public int totalAttempts = 0; // �õ� Ƚ���� public���� ����
    public int successfulAttempts = 0; // ���� Ƚ���� public���� ����

    bool isRecording = false;
    bool isSoundDetected = false;
    float detectionThreshold = 0.01f; // "��" �Ҹ��� �����ϴ� �Ӱ谪
    float soundLostTime = 0f; // �Ҹ� ������ ���� �ð�
    float maxSoundLostDuration = 0.1f; // �Ҹ� ������ ���ܵ� ���� ���¸� �����ϴ� �ִ� �ð�

    float soundDetectedTime = 0f; // "��" �Ҹ��� ������ �ð�

    public float maxSize = 1.2f; // ��ü�� �ִ� ũ��
    public float maxGrowthTime = 3f; // ��ü�� �ִ� ũ�⿡ �����ϴ� �� �ɸ��� �ð�
    public float holdTime = 1f; // ���� �� ���� �ð� 1��

    List<GameObject> spheres = new List<GameObject>(); // ������ ������Ʈ�� ������ ����Ʈ
    Vector3 initialPosition = new Vector3(0.028f, 0.223f, -4.328f); // ���ο� sphere�� ������ ��ġ

    private const string apiUrl = "http://localhost:8080/trainings/bt/"; // ���� URL
    private float[] pitchLevels = new float[6]; // ��ġ�� ������ �迭

    private GameController gameController;

    private List<Color> predefinedColors = new List<Color>
    {
        new Color(0f, 0.8f, 0.9f), // Light Blue
        new Color(1.0f, 0.1f, 0.1f), // Red
        new Color(1.0f, 0.85f, 0.09f), // Yellow
        new Color(0.79f, 1f, 0.4f), // Green
        new Color(1.0f, 0.62f, 0.06f), // Orange
        new Color(1.0f, 0.3f, 0.58f), // Pink
        new Color(0.62f, 0.24f, 1f)  // Purple
    };

    private List<Color> usedColors = new List<Color>();

    void Start()
    {
        aud = GetComponent<AudioSource>();
        gameController = FindObjectOfType<GameController>();
    }

    void Update()
    {
        if (isRecording)
        {
            float[] samples = new float[256];
            aud.GetOutputData(samples, 0);
            float level = 0;
            foreach (float sample in samples)
            {
                level += Mathf.Abs(sample);
            }
            level /= samples.Length;

            if (level >= detectionThreshold && level <= 0.1f)
            {
                soundLostTime = 0f; // ������ ��� ���� �ð��� �ʱ�ȭ
                if (!isSoundDetected)
                {
                    isSoundDetected = true;
                    circleTimer.SetSoundDetection(true);
                    circleTimer.StartTimer();
                }
                soundDetectedTime += Time.deltaTime;
            }
            else
            {
                soundLostTime += Time.deltaTime; // �������� ���� �ð� ����

                if (soundLostTime >= maxSoundLostDuration)
                {
                    if (isSoundDetected)
                    {
                        // �Ҹ� ������ ������ �� ����� �޽����� ����մϴ�.
                        Debug.Log($"Sound detection lost. Time: {soundDetectedTime:F2} seconds, Level: {level:F4}");

                        isSoundDetected = false;
                        circleTimer.SetSoundDetection(false);
                        circleTimer.StopTimer();

                        if (soundDetectedTime < 3f)
                        {
                            StopRecording();
                            StartCoroutine(ShrinkObjectOverTime(sphereObjectPrefab, 1f));
                            UpdateStatusText("����! �ٽ� �õ��غ�����");
                            timeText.text = "ȣ�� ���� �ð� : 0.00��";
                            SaveAndSendGameData(false);
                            soundDetectedTime = 0f;
                            isRecording = false;
                            totalAttempts++;
                            UpdateAttemptsText();
                            CheckEndCondition();
                        }
                    }
                }
            }

            if (level >= detectionThreshold && level <= 0.1f)
            {
                isSoundDetected = true;
                UpdateStatusText("�������Դϴ�");
                soundDetectedTime += Time.deltaTime;

                if (soundDetectedTime < maxGrowthTime)
                {
                    float growthRatio = soundDetectedTime / maxGrowthTime;
                    Vector3 targetScale = Vector3.Lerp(Vector3.one * 0.5f, Vector3.one * maxSize, growthRatio);
                    sphereObjectPrefab.transform.localScale = targetScale;
                    timeText.text = "ȣ�� ���� �ð� : " + soundDetectedTime.ToString("F2") + "��";
                }
                else
                {
                    sphereObjectPrefab.transform.localScale = new Vector3(maxSize, maxSize, maxSize);
                    StopRecording();
                    UpdateStatusText("�����Դϴ�!");
                    timeText.text = "ȣ�� ���� �ð� : 3.00��";
                    MoveSphereToSpawnPoint();
                    CreateNewSphere();
                    SaveAndSendGameData(true);

                    isRecording = false;
                    isSoundDetected = false;
                    circleTimer.SetSoundDetection(false);
                    circleTimer.StopTimer();

                    totalAttempts++;
                    UpdateAttemptsText();
                    gameController.CheckEndGameCondition();
                }

                if (soundDetectedTime >= 0.5f && pitchLevels[0] == 0)
                {
                    pitchLevels[0] = level;
                }
                if (soundDetectedTime >= 1.0f && pitchLevels[1] == 0)
                {
                    pitchLevels[1] = level;
                }
                if (soundDetectedTime >= 1.5f && pitchLevels[2] == 0)
                {
                    pitchLevels[2] = level;
                }
                if (soundDetectedTime >= 2.0f && pitchLevels[3] == 0)
                {
                    pitchLevels[3] = level;
                }
                if (soundDetectedTime >= 2.5f && pitchLevels[4] == 0)
                {
                    pitchLevels[4] = level;
                }
                if (soundDetectedTime >= 2.99f && pitchLevels[5] == 0)
                {
                    pitchLevels[5] = level;
                }
            }
        }
    }

    void SaveAndSendGameData(bool success)
    {
        string roundedLength = soundDetectedTime.ToString("0.00");
        string roundedPitch1 = pitchLevels[0].ToString("0.00");
        string roundedPitch2 = pitchLevels[1].ToString("0.00");
        string roundedPitch3 = pitchLevels[2].ToString("0.00");
        string roundedPitch4 = pitchLevels[3].ToString("0.00");
        string roundedPitch5 = pitchLevels[4].ToString("0.00");
        string roundedPitch6 = pitchLevels[5].ToString("0.00");

        Debug.Log("SaveAndSendGameData called with success: " + success);
        Debug.Log("soundDetectedTime: " + roundedLength);
        Debug.Log("pitchLevels: " + roundedPitch1 + ", " + roundedPitch2 + ", " + roundedPitch3 + ", " + roundedPitch4 + ", " + roundedPitch5 + ", " + roundedPitch6);

        GameData data = new GameData
        {
            bt_length = float.Parse(roundedLength),
            bt_pitch1 = float.Parse(roundedPitch1),
            bt_pitch2 = float.Parse(roundedPitch2),
            bt_pitch3 = float.Parse(roundedPitch3),
            bt_pitch4 = float.Parse(roundedPitch4),
            bt_pitch5 = float.Parse(roundedPitch5),
            bt_pitch6 = float.Parse(roundedPitch6),
            bt_times = totalAttempts + 1,
            bt_success = success ? 1 : 0
        };

        string jsonData = JsonUtility.ToJson(data);
        StartCoroutine(SendDataToServer(jsonData));

        pitchLevels = new float[6];

        UpdateAttemptsText();
    }

    private IEnumerator SendDataToServer(string jsonData)
    {
        Debug.Log("Sending data: " + jsonData);
        using (UnityWebRequest request = new UnityWebRequest(apiUrl, "POST"))
        {
            byte[] bodyRaw = Encoding.UTF8.GetBytes(jsonData);
            request.uploadHandler = new UploadHandlerRaw(bodyRaw);
            request.downloadHandler = new DownloadHandlerBuffer();
            request.SetRequestHeader("Content-Type", "application/json");

            yield return request.SendWebRequest();

            if (request.result == UnityWebRequest.Result.Success)
            {
                Debug.Log("Data sent successfully: " + request.downloadHandler.text);
            }
            else
            {
                Debug.LogError("Error sending data: " + request.error);
            }
        }
    }

    void StopRecording()
    {
        isRecording = false;
        Microphone.End(Microphone.devices[0]);
    }

    IEnumerator ShrinkObjectOverTime(GameObject obj, float duration)
    {
        Vector3 initialScale = obj.transform.localScale;
        Vector3 targetScale = Vector3.one * 0.5f;

        float elapsedTime = 0f;

        while (elapsedTime < duration)
        {
            float t = elapsedTime / duration;
            obj.transform.localScale = Vector3.Lerp(initialScale, targetScale, t);
            elapsedTime += Time.deltaTime;
            yield return null;
        }
        obj.transform.localScale = targetScale;
    }

    void UpdateStatusText(string message)
    {
        statusText.text = message;
    }

    void MoveSphereToSpawnPoint()
    {
        if (spheres.Count < sphereSpawnPoints.Length)
        {
            int index = spheres.Count;
            Vector3 spawnPosition = sphereSpawnPoints[index].position;
            sphereObjectPrefab.transform.position = spawnPosition;
        }
    }

    void CreateNewSphere()
    {
        if (spheres.Count < 5)
        {
            Vector3 originalPosition = initialPosition;

            GameObject newSphere = Instantiate(sphereObjectPrefab, originalPosition, Quaternion.identity);
            newSphere.transform.localScale = Vector3.one * 0.5f;

            List<Color> availableColors = new List<Color>(predefinedColors);
            foreach (Color usedColor in usedColors)
            {
                if (availableColors.Contains(usedColor))
                {
                    availableColors.Remove(usedColor);
                }
            }

            if (availableColors.Count > 0)
            {
                Color newColor = availableColors[Random.Range(0, availableColors.Count)];
                newSphere.GetComponent<Renderer>().material.color = newColor;
                usedColors.Add(newColor);
            }

            AudioSource newSphereAudio = newSphere.AddComponent<AudioSource>();
            newSphereAudio.clip = Microphone.Start(Microphone.devices[0], true, 10, 44100);
            newSphereAudio.loop = true;
            newSphereAudio.Play();

            spheres.Add(newSphere);

            StartRecordingForSphere(newSphereAudio);

            sphereObjectPrefab = spheres[spheres.Count - 1];

            if (balloonSliderController != null)
            {
                balloonSliderController.AddBalloon();
            }

            successfulAttempts++;
        }
    }

    void StartRecordingForSphere(AudioSource audioSource)
    {
        aud = audioSource;
        isRecording = true;
    }

    public int GetSphereCount()
    {
        return spheres.Count;
    }

    void CheckEndCondition()
    {
        if (totalAttempts >= 10 || successfulAttempts >= 5)
        {
            string endMessage = successfulAttempts >= 5 ? "������ ����Ǿ����ϴ�. ���ϼ̾��!" : "������ ����Ǿ����ϴ�. �� ��������!";

            UpdateStatusText(endMessage);
            enabled = false;
        }
    }

    void UpdateAttemptsText()
    {
        attemptsText.text = totalAttempts + "/10";
    }

    public void Recsnd()
    {
        if (Microphone.devices.Length > 0)
        {
            aud.clip = Microphone.Start(Microphone.devices[0], true, 10, 16000);
            while (!(Microphone.GetPosition(null) > 0)) { }
            aud.Play();
            isRecording = true;
            soundDetectedTime = 0f;
            isSoundDetected = false;
        }
    }
}
