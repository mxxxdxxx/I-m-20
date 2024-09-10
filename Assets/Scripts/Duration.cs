using UnityEngine;
using UnityEngine.UI;

public class DurationGraph : MonoBehaviour
{
    public Image durationBar; // ����� ���� �׷����� ǥ���� UI ���

    void Start()
    {
        // �������� �����͸� ��������, �����͸� �̿��� �׷��� ������Ʈ
        UpdateGraph();
    }

    public void UpdateGraph()
    {
        float[] durations = TrainingDataFetcher.instance.GetDurations(); // �������� ������ ���ӽð� �迭
        float averageDuration = 0;

        // ��� ���ӽð� ���
        for (int i = 0; i < durations.Length; i++)
        {
            averageDuration += durations[i];
        }
        averageDuration /= durations.Length;

        // ���� �׷����� ��� ���ӽð��� �°� ���� (�ִ� 3�ʰ� ����)
        durationBar.fillAmount = averageDuration / 3f;
    }
}
