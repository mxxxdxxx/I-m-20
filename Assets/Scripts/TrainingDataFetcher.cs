using System.Collections;
using UnityEngine;
using UnityEngine.Networking;
using System.Collections.Generic;

public class TrainingDataFetcher : MonoBehaviour
{
    public static TrainingDataFetcher instance; // 싱글톤으로 데이터를 어디서든 접근 가능하게 하기 위함

    // 서버에서 가져올 데이터 구조체
    [System.Serializable]
    public class TrainingData
    {
        public float[] durations; // 각 시도의 지속시간
        public float[] volumes;   // 각 시도의 볼륨
        public int balloonCount;  // 풍선 개수
    }

    public TrainingData trainingData; // 서버에서 받아온 데이터를 저장

    private string serverUrl = "http://localhost:8080/trainingdata"; // 서버 주소

    void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject); // 씬 전환에도 파괴되지 않음
        }
        else
        {
            Destroy(gameObject);
        }
    }

    // 서버에서 데이터를 가져오는 함수
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
            trainingData = JsonUtility.FromJson<TrainingData>(jsonResult); // 서버로부터 데이터를 구조체에 저장
            Debug.Log("Training data fetched successfully.");
        }
        else
        {
            Debug.LogError("Failed to fetch training data: " + request.error);
        }
    }

    // 각 데이터에 접근할 수 있는 메서드 추가 (필요에 따라 추가)
    public float[] GetDurations() { return trainingData.durations; }
    public float[] GetVolumes() { return trainingData.volumes; }
    public int GetBalloonCount() { return trainingData.balloonCount; }
}
