using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class peaki : MonoBehaviour
{
    public float moveDistance = 500f; // �̵��� �Ÿ�
    public float speed = 100f; // �����̴� �ӵ�
    public float jumpHeight = 50f; // ���� ����
    public float jumpFrequency = 1f; // ���� ��
    private Vector3 startPosition; // ���� ��ġ
    private bool movingRight = true; // ���������� �̵� ������ ����
    private float jumpTime; // ���� Ÿ�̸�

    void Start()
    {
        // ������Ʈ�� ���� ��ġ�� �����մϴ�.
        startPosition = transform.localPosition;
        jumpTime = 0f;
    }

    void Update()
    {
        // ���� ��ġ�� �����ɴϴ�.
        Vector3 currentPosition = transform.localPosition;

        // �̵��� �Ÿ��� ����մϴ�.
        float step = speed * Time.deltaTime;

        // ���������� �̵� ���� ���
        if (movingRight)
        {
            // ���������� �̵�
            currentPosition.x += step;

            // ������ ���� ������ ��� ������ �ٲߴϴ�.
            if (currentPosition.x >= startPosition.x + moveDistance)
            {
                movingRight = false;
            }
        }
        else
        {
            // �������� �̵�
            currentPosition.x -= step;

            // ���� ���� ������ ��� ������ �ٲߴϴ�.
            if (currentPosition.x <= startPosition.x)
            {
                movingRight = true;
            }
        }

        // ���� ȿ���� ���� y ��ġ ���
        jumpTime += Time.deltaTime * jumpFrequency;
        currentPosition.y = startPosition.y + Mathf.Abs(Mathf.Sin(jumpTime) * jumpHeight);

        // Ʈ�������� �̿��� ������Ʈ ��ġ�� ������Ʈ�մϴ�.
        transform.localPosition = currentPosition;
    }
}
