using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class cloud : MonoBehaviour
{
    public float speed = 5f; // �����̴� �ӵ�
    public float jumpHeight = 5f; // ���� ����
    public float jumpFrequency = 0.5f; // ���� ��
    public float moveRange = 200f; // �̵��� ����
    private Vector3 startPosition; // ���� ��ġ
    private Vector3 targetPosition; // ��ǥ ��ġ
    private float jumpTime; // ���� Ÿ�̸�

    void Start()
    {
        // ������Ʈ�� ���� ��ġ�� �����մϴ�.
        startPosition = transform.localPosition;
        SetNewTargetPosition();
        jumpTime = 0f;
    }

    void Update()
    {
        // ���� ��ġ�� �����ɴϴ�.
        Vector3 currentPosition = transform.localPosition;

        // ��ǥ ��ġ�� �̵��մϴ�.
        float step = speed * Time.deltaTime;
        transform.localPosition = Vector3.MoveTowards(currentPosition, targetPosition, step);

        // ��ǥ ��ġ�� �����ϸ� ���ο� ��ǥ ��ġ�� �����մϴ�.
        if (Vector3.Distance(transform.localPosition, targetPosition) < 0.1f)
        {
            SetNewTargetPosition();
        }

        // ���� ȿ���� ���� y ��ġ ���
        jumpTime += Time.deltaTime * jumpFrequency;
        currentPosition.y = startPosition.y + Mathf.Abs(Mathf.Sin(jumpTime) * jumpHeight);

        // Ʈ�������� �̿��� ������Ʈ ��ġ�� ������Ʈ�մϴ�.
        transform.localPosition = new Vector3(transform.localPosition.x, currentPosition.y, transform.localPosition.z);
    }

    void SetNewTargetPosition()
    {
        // ������ ��ǥ ��ġ�� �����մϴ�.
        float randomX = Random.Range(startPosition.x - moveRange, startPosition.x + moveRange);
        float randomY = startPosition.y; // ���� �̵��� ���, ���� �̵��� ������ ��ü
        targetPosition = new Vector3(randomX, randomY, startPosition.z);
    }
}
