using System.Collections;
using UnityEngine;
using UnityEngine.Networking;
using System.Collections.Generic;

public class TrainingDataFetcher : MonoBehaviour
{
    public static TrainingDataFetcher instance; // �̱������� �����͸� ��𼭵� ���� �����ϰ� �ϱ� ����

    // �������� ������ ������ ����ü
    [System.Serializable]
    public class TrainingData
    {
        public float[] durations; // �� �õ��� ���ӽð�
        public float[] volumes;   // �� �õ��� ����
        public int balloonCount;  // ǳ�� ����
    }

    public TrainingData trainingData; // �������� �޾ƿ� �����͸� ����

    private string serverUrl = "http://localhost:8080/trainingdata"; // ���� �ּ�

    void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject); // �� ��ȯ���� �ı����� ����
        }
        else
        {
            Destroy(gameObject);
        }
    }

    // �������� �����͸� �������� �Լ�
    public void FetchTrainingData()
    {
        StartCoroutine(GetTrainingDataFromServer());
    }

    IEnumerator GetTrainingDataFromServer()
    {
        UnityWebRequest request = UnityWebRequest.Get(serverUrl);

        yield return request.SendWebRequest();

        if (request.result != UnityWebRequest.Result.ConnectionError && request.result != UnityWebRequest.Result.ProtocolError)
        {
            string jsonResult = request.downloadHandler.text;
            trainingData = JsonUtility.FromJson<TrainingData>(jsonResult); // �����κ��� �����͸� ����ü�� ����
            Debug.Log("Training data fetched successfully.");
        }
        else
        {
            Debug.LogError("Failed to fetch training data: " + request.error);
        }
    }

    // �� �����Ϳ� ������ �� �ִ� �޼��� �߰� (�ʿ信 ���� �߰�)
    public float[] GetDurations() { return trainingData.durations; }
    public float[] GetVolumes() { return trainingData.volumes; }
    public int GetBalloonCount() { return trainingData.balloonCount; }
}
