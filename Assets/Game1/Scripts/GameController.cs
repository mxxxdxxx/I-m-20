using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement; // 씬 관리 네임스페이스 추가

public class GameController : MonoBehaviour
{
    public GameObject gameSuccessUI; // 게임 성공 UI 참조
    public GameObject gameFailUI; // 게임 실패 UI 참조
    public Mic micScript; // Mic 스크립트 참조
    public Text attemptsText; // 게임 성공 UI에 표시할 Attempts Text 참조
    public Text failAttemptsText; // 게임 실패 UI에 표시할 Attempts Text 참조
    public Text successBalloonsText; // 성공한 풍선 개수를 표시할 Text 참조

    public GameObject image1; // 성공한 풍선 1개일 때 활성화할 이미지
    public GameObject image2; // 성공한 풍선 2개일 때 활성화할 이미지
    public GameObject image3; // 성공한 풍선 3개일 때 활성화할 이미지
    public GameObject image4; // 성공한 풍선 4개일 때 활성화할 이미지

    void Start()
    {
        gameSuccessUI.SetActive(false); // 게임 시작 시 성공 UI 숨김
        gameFailUI.SetActive(false); // 게임 시작 시 실패 UI 숨김
        
        // 모든 이미지를 비활성화
        image1.SetActive(false);
        image2.SetActive(false);
        image3.SetActive(false);
        image4.SetActive(false);
    }

    void Update()
    {
        CheckEndGameCondition();
        UpdateSuccessImages(); // 성공한 풍선 개수에 따라 이미지 업데이트
    }

    public void CheckEndGameCondition()
    {
        // Mic 스크립트의 spheres 리스트를 참조하여 5개가 되었는지 확인
        if (micScript.GetSphereCount() >= 5)
        {
            gameSuccessUI.SetActive(true); // 게임 종료 UI 활성화
            attemptsText.text = micScript.totalAttempts.ToString() + " 회";
            micScript.enabled = false; // Mic 스크립트 비활성화
        }

        // 시도 횟수가 10번을 초과하면 실패 UI 활성화
        else if (micScript.totalAttempts >= 10)
        {
            gameFailUI.SetActive(true); // 게임 실패 UI 활성화
            failAttemptsText.text = micScript.totalAttempts.ToString() + " 회"; // 시도 횟수 업데이트
            successBalloonsText.text = "성공 풍선 개수 : "; // 성공한 풍선 개수 업데이트
            micScript.enabled = false; // Mic 스크립트 비활성화
        }
    }

    public void UpdateSuccessImages()
    {
        // 모든 이미지를 비활성화
        image1.SetActive(false);
        image2.SetActive(false);
        image3.SetActive(false);
        image4.SetActive(false);

        // 성공한 풍선 개수에 따라 해당 이미지 하나만 활성화
        if (micScript.successfulAttempts == 1)
        {
            image1.SetActive(true);
        }
        else if (micScript.successfulAttempts == 2)
        {
            image2.SetActive(true);
        }
        else if (micScript.successfulAttempts == 3)
        {
            image3.SetActive(true);
        }
        else if (micScript.successfulAttempts == 4)
        {
            image4.SetActive(true);
        }
    }

    public void RestartGame()
    {
        // 현재 씬을 다시 로드하여 게임을 재시작
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }
}
