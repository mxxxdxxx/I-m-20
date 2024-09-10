using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI; // UI 요소 사용하기 위해 추가
using UnityEngine.Networking;
using System.Text;

[System.Serializable] // 직렬화
public class GameData // 데이터 저장하는 클래스입니다. 아래 변수들은 데이터를 저장하기 위해 사용.
{
    public float bt_length; // 소리 길이
    public float bt_pitch1; // 소리 높낮이 = 성량(0.5초 단위로  bt_pitch1~bt_pitch6까지 저장)
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

    public GameObject sphereObjectPrefab; // 조절할 sphere object의 프리팹
    public Transform[] sphereSpawnPoints; // 새로운 object가 생성될 위치
    public Text timeText; // UI Text 레퍼런스
    public Text statusText; // 시작 실패 종료 text
    public BalloonSliderController balloonSliderController; // 슬라이더 컨트롤러 참조 추가
    public Text attemptsText; // 녹음 시도 횟수를 표시할 UI Text 참조
    public CircleTimer circleTimer; // CircleTimer 참조를 위한 public 변수 추가

    public int totalAttempts = 0; // 시도 횟수를 public으로 변경
    public int successfulAttempts = 0; // 성공 횟수를 public으로 변경

    bool isRecording = false;
    bool isSoundDetected = false;
    float detectionThreshold = 0.01f; // "아" 소리를 감지하는 임계값
    float soundLostTime = 0f; // 소리 감지가 끊긴 시간
    float maxSoundLostDuration = 0.1f; // 소리 감지가 끊겨도 감지 상태를 유지하는 최대 시간

    float soundDetectedTime = 0f; // "아" 소리가 감지된 시간

    public float maxSize = 1.2f; // 물체의 최대 크기
    public float maxGrowthTime = 3f; // 물체가 최대 크기에 도달하는 데 걸리는 시간
    public float holdTime = 1f; // 성공 후 유지 시간 1초

    List<GameObject> spheres = new List<GameObject>(); // 생성된 오브젝트를 저장할 리스트
    Vector3 initialPosition = new Vector3(0.028f, 0.223f, -4.328f); // 새로운 sphere가 생성될 위치

    private const string apiUrl = "http://localhost:8080/trainings/bt/"; // 서버 URL
    private float[] pitchLevels = new float[6]; // 피치를 저장할 배열

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
                soundLostTime = 0f; // 감지된 경우 끊김 시간을 초기화
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
                soundLostTime += Time.deltaTime; // 감지되지 않은 시간 누적

                if (soundLostTime >= maxSoundLostDuration)
                {
                    if (isSoundDetected)
                    {
                        // 소리 감지가 끊겼을 때 디버그 메시지를 출력합니다.
                        Debug.Log($"Sound detection lost. Time: {soundDetectedTime:F2} seconds, Level: {level:F4}");

                        isSoundDetected = false;
                        circleTimer.SetSoundDetection(false);
                        circleTimer.StopTimer();

                        if (soundDetectedTime < 3f)
                        {
                            StopRecording();
                            StartCoroutine(ShrinkObjectOverTime(sphereObjectPrefab, 1f));
                            UpdateStatusText("실패! 다시 시도해보세요");
                            timeText.text = "호흡 지속 시간 : 0.00초";
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
                UpdateStatusText("녹음중입니다");
                soundDetectedTime += Time.deltaTime;

                if (soundDetectedTime < maxGrowthTime)
                {
                    float growthRatio = soundDetectedTime / maxGrowthTime;
                    Vector3 targetScale = Vector3.Lerp(Vector3.one * 0.5f, Vector3.one * maxSize, growthRatio);
                    sphereObjectPrefab.transform.localScale = targetScale;
                    timeText.text = "호흡 지속 시간 : " + soundDetectedTime.ToString("F2") + "초";
                }
                else
                {
                    sphereObjectPrefab.transform.localScale = new Vector3(maxSize, maxSize, maxSize);
                    StopRecording();
                    UpdateStatusText("성공입니다!");
                    timeText.text = "호흡 지속 시간 : 3.00초";
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
            string endMessage = successfulAttempts >= 5 ? "게임이 종료되었습니다. 잘하셨어요!" : "게임이 종료되었습니다. 더 힘내봐요!";

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
