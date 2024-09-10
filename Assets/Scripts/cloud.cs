using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class cloud : MonoBehaviour
{
    public float speed = 5f; // 움직이는 속도
    public float jumpHeight = 5f; // 점프 높이
    public float jumpFrequency = 0.5f; // 점프 빈도
    public float moveRange = 200f; // 이동할 범위
    private Vector3 startPosition; // 시작 위치
    private Vector3 targetPosition; // 목표 위치
    private float jumpTime; // 점프 타이머

    void Start()
    {
        // 오브젝트의 시작 위치를 저장합니다.
        startPosition = transform.localPosition;
        SetNewTargetPosition();
        jumpTime = 0f;
    }

    void Update()
    {
        // 현재 위치를 가져옵니다.
        Vector3 currentPosition = transform.localPosition;

        // 목표 위치로 이동합니다.
        float step = speed * Time.deltaTime;
        transform.localPosition = Vector3.MoveTowards(currentPosition, targetPosition, step);

        // 목표 위치에 도달하면 새로운 목표 위치를 설정합니다.
        if (Vector3.Distance(transform.localPosition, targetPosition) < 0.1f)
        {
            SetNewTargetPosition();
        }

        // 점프 효과를 위한 y 위치 계산
        jumpTime += Time.deltaTime * jumpFrequency;
        currentPosition.y = startPosition.y + Mathf.Abs(Mathf.Sin(jumpTime) * jumpHeight);

        // 트랜스폼을 이용해 오브젝트 위치를 업데이트합니다.
        transform.localPosition = new Vector3(transform.localPosition.x, currentPosition.y, transform.localPosition.z);
    }

    void SetNewTargetPosition()
    {
        // 무작위 목표 위치를 설정합니다.
        float randomX = Random.Range(startPosition.x - moveRange, startPosition.x + moveRange);
        float randomY = startPosition.y; // 수평 이동만 고려, 수직 이동은 점프로 대체
        targetPosition = new Vector3(randomX, randomY, startPosition.z);
    }
}
