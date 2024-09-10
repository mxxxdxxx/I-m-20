using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class peaki : MonoBehaviour
{
    public float moveDistance = 500f; // 이동할 거리
    public float speed = 100f; // 움직이는 속도
    public float jumpHeight = 50f; // 점프 높이
    public float jumpFrequency = 1f; // 점프 빈도
    private Vector3 startPosition; // 시작 위치
    private bool movingRight = true; // 오른쪽으로 이동 중인지 여부
    private float jumpTime; // 점프 타이머

    void Start()
    {
        // 오브젝트의 시작 위치를 저장합니다.
        startPosition = transform.localPosition;
        jumpTime = 0f;
    }

    void Update()
    {
        // 현재 위치를 가져옵니다.
        Vector3 currentPosition = transform.localPosition;

        // 이동할 거리를 계산합니다.
        float step = speed * Time.deltaTime;

        // 오른쪽으로 이동 중인 경우
        if (movingRight)
        {
            // 오른쪽으로 이동
            currentPosition.x += step;

            // 오른쪽 끝에 도달한 경우 방향을 바꿉니다.
            if (currentPosition.x >= startPosition.x + moveDistance)
            {
                movingRight = false;
            }
        }
        else
        {
            // 왼쪽으로 이동
            currentPosition.x -= step;

            // 왼쪽 끝에 도달한 경우 방향을 바꿉니다.
            if (currentPosition.x <= startPosition.x)
            {
                movingRight = true;
            }
        }

        // 점프 효과를 위한 y 위치 계산
        jumpTime += Time.deltaTime * jumpFrequency;
        currentPosition.y = startPosition.y + Mathf.Abs(Mathf.Sin(jumpTime) * jumpHeight);

        // 트랜스폼을 이용해 오브젝트 위치를 업데이트합니다.
        transform.localPosition = currentPosition;
    }
}
