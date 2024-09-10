using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class CanvasManager : MonoBehaviour
{
    public static CanvasManager instance;

    // 모든 캔버스를 선언
    public Canvas startCanvas;
    public Canvas loginCanvas;
    public Canvas signUpCanvas;
    public Canvas sufinishCanvas;
    public Canvas test1Canvas;
    public Canvas test2Canvas;
    public Canvas test3Canvas;
    public Canvas test4Canvas;
    public Canvas test5Canvas;
    public Canvas levelCanvas;
    public Canvas placeCanvas; // place 캔버스
    public Canvas training1Canvas;
    public Canvas training2Canvas;
    public Canvas feedBackCanvas;
    public Canvas BreathFB;
    public Canvas PronunciationFB;
    public Canvas FluentFB;
    public Canvas parentPasswordCanvas;

    public string gameSceneName = "BreathGame";

    private Canvas currentCanvas;

    // 싱글톤 패턴 설정
    private void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject);
        }
        else
        {
            Destroy(gameObject);
        }

        currentCanvas = startCanvas; // 처음 활성화될 캔버스 설정
        currentCanvas.gameObject.SetActive(true);
    }

    // 로그인 -> Training1으로 전환
    public void SwitchToTraining1()
    {
        SwitchCanvas(currentCanvas, training1Canvas);
    }

    // 로그인 -> SignUp으로 전환
    public void SwitchToSignUp()
    {
        SwitchCanvas(currentCanvas, signUpCanvas);
    }

    // Start -> Login Canvas 전환
    public void SwitchToLogin()
    {
        SwitchCanvas(currentCanvas, loginCanvas);
    }

    // sufinish -> Test1 Canvas 전환
    public void SwitchToTest1()
    {
        SwitchCanvas(currentCanvas, test1Canvas);
    }

    // Test1 -> Test2 Canvas 전환
    public void SwitchToTest2()
    {
        SwitchCanvas(currentCanvas, test2Canvas);
    }

    // Test2 -> Test3 Canvas 전환
    public void SwitchToTest3()
    {
        SwitchCanvas(currentCanvas, test3Canvas);
    }

    // Test3 -> Test4 Canvas 전환
    public void SwitchToTest4()
    {
        SwitchCanvas(currentCanvas, test4Canvas);
    }

    // Test4 -> Test5 Canvas 전환
    public void SwitchToTest5()
    {
        SwitchCanvas(currentCanvas, test5Canvas);
    }

    // Test5 -> Level Canvas 전환
    public void SwitchToLevel()
    {
        SwitchCanvas(currentCanvas, levelCanvas);
    }

    // Place -> Training1 Canvas 전환
    public void ShowTraining1Canvas()
    {
        SwitchCanvas(currentCanvas, training1Canvas);
    }

    // Place -> Training2 Canvas 전환
    public void ShowTraining2Canvas()
    {
        SwitchCanvas(currentCanvas, training2Canvas);
    }

    // Feedback Canvas에서 목표 Canvas들로 전환
    public void SwitchToBreathFB()
    {
        SwitchCanvas(currentCanvas, BreathFB);
    }

    public void SwitchToPronunciationFB()
    {
        SwitchCanvas(currentCanvas, PronunciationFB);
    }

    public void SwitchToFluentFB()
    {
        SwitchCanvas(currentCanvas, FluentFB);
    }

    // 학부모 비밀번호 캔버스 -> 피드백 캔버스 전환
    public void SwitchToFeedbackCanvas()
    {
        SwitchCanvas(currentCanvas, feedBackCanvas);
    }

    // SignUp -> sufinish 캔버스 전환
    public void SwitchToSufinish()
    {
        SwitchCanvas(currentCanvas, sufinishCanvas);
    }

    // Place Canvas로 전환 (추가된 부분)
    public void SwitchToPlace()
    {
        SwitchCanvas(currentCanvas, placeCanvas);
    }

    // 모든 캔버스를 비활성화하고 특정 캔버스만 활성화하는 함수
    private void SwitchCanvas(Canvas currentCanvas, Canvas newCanvas)
    {
        if (currentCanvas != null)
        {
            Debug.Log("Deactivating: " + currentCanvas.name);
            currentCanvas.gameObject.SetActive(false);
        }

        if (newCanvas != null)
        {
            Debug.Log("Activating: " + newCanvas.name);
            newCanvas.gameObject.SetActive(true);
            AlignCanvasTransform(newCanvas, currentCanvas);
            this.currentCanvas = newCanvas; // 현재 캔버스를 업데이트
        }
    }

    // 캔버스 전환 시 위치, 회전, 크기 동기화
    private void AlignCanvasTransform(Canvas newCanvas, Canvas oldCanvas)
    {
        if (oldCanvas != null)
        {
            newCanvas.transform.position = oldCanvas.transform.position;
            newCanvas.transform.rotation = oldCanvas.transform.rotation;
            newCanvas.transform.localScale = oldCanvas.transform.localScale;
        }
    }

    // 게임 씬으로 전환
    public void SwitchToGameScene()
    {
        SceneManager.LoadScene(gameSceneName);
    }
}
