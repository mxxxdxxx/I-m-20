using UnityEngine;
using UnityEngine.UI;

public class DurationGraph : MonoBehaviour
{
    public Image durationBar; // 노란색 막대 그래프를 표현할 UI 요소

    void Start()
    {
        // 서버에서 데이터를 가져오고, 데이터를 이용해 그래프 업데이트
        UpdateGraph();
    }

    public void UpdateGraph()
    {
        float[] durations = TrainingDataFetcher.instance.GetDurations(); // 서버에서 가져온 지속시간 배열
        float averageDuration = 0;

        // 평균 지속시간 계산
        for (int i = 0; i < durations.Length; i++)
        {
            averageDuration += durations[i];
        }
        averageDuration /= durations.Length;

        // 막대 그래프를 평균 지속시간에 맞게 조정 (최대 3초가 기준)
        durationBar.fillAmount = averageDuration / 3f;
    }
}
