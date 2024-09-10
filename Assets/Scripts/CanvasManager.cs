using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class CanvasManager : MonoBehaviour
{
    public static CanvasManager instance;

    // ��� ĵ������ ����
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
    public Canvas placeCanvas; // place ĵ����
    public Canvas training1Canvas;
    public Canvas training2Canvas;
    public Canvas feedBackCanvas;
    public Canvas BreathFB;
    public Canvas PronunciationFB;
    public Canvas FluentFB;
    public Canvas parentPasswordCanvas;

    public string gameSceneName = "BreathGame";

    private Canvas currentCanvas;

    // �̱��� ���� ����
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

        currentCanvas = startCanvas; // ó�� Ȱ��ȭ�� ĵ���� ����
        currentCanvas.gameObject.SetActive(true);
    }

    // �α��� -> Training1���� ��ȯ
    public void SwitchToTraining1()
    {
        SwitchCanvas(currentCanvas, training1Canvas);
    }

    // �α��� -> SignUp���� ��ȯ
    public void SwitchToSignUp()
    {
        SwitchCanvas(currentCanvas, signUpCanvas);
    }

    // Start -> Login Canvas ��ȯ
    public void SwitchToLogin()
    {
        SwitchCanvas(currentCanvas, loginCanvas);
    }

    // sufinish -> Test1 Canvas ��ȯ
    public void SwitchToTest1()
    {
        SwitchCanvas(currentCanvas, test1Canvas);
    }

    // Test1 -> Test2 Canvas ��ȯ
    public void SwitchToTest2()
    {
        SwitchCanvas(currentCanvas, test2Canvas);
    }

    // Test2 -> Test3 Canvas ��ȯ
    public void SwitchToTest3()
    {
        SwitchCanvas(currentCanvas, test3Canvas);
    }

    // Test3 -> Test4 Canvas ��ȯ
    public void SwitchToTest4()
    {
        SwitchCanvas(currentCanvas, test4Canvas);
    }

    // Test4 -> Test5 Canvas ��ȯ
    public void SwitchToTest5()
    {
        SwitchCanvas(currentCanvas, test5Canvas);
    }

    // Test5 -> Level Canvas ��ȯ
    public void SwitchToLevel()
    {
        SwitchCanvas(currentCanvas, levelCanvas);
    }

    // Place -> Training1 Canvas ��ȯ
    public void ShowTraining1Canvas()
    {
        SwitchCanvas(currentCanvas, training1Canvas);
    }

    // Place -> Training2 Canvas ��ȯ
    public void ShowTraining2Canvas()
    {
        SwitchCanvas(currentCanvas, training2Canvas);
    }

    // Feedback Canvas���� ��ǥ Canvas��� ��ȯ
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

    // �кθ� ��й�ȣ ĵ���� -> �ǵ�� ĵ���� ��ȯ
    public void SwitchToFeedbackCanvas()
    {
        SwitchCanvas(currentCanvas, feedBackCanvas);
    }

    // SignUp -> sufinish ĵ���� ��ȯ
    public void SwitchToSufinish()
    {
        SwitchCanvas(currentCanvas, sufinishCanvas);
    }

    // Place Canvas�� ��ȯ (�߰��� �κ�)
    public void SwitchToPlace()
    {
        SwitchCanvas(currentCanvas, placeCanvas);
    }

    // ��� ĵ������ ��Ȱ��ȭ�ϰ� Ư�� ĵ������ Ȱ��ȭ�ϴ� �Լ�
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
            this.currentCanvas = newCanvas; // ���� ĵ������ ������Ʈ
        }
    }

    // ĵ���� ��ȯ �� ��ġ, ȸ��, ũ�� ����ȭ
    private void AlignCanvasTransform(Canvas newCanvas, Canvas oldCanvas)
    {
        if (oldCanvas != null)
        {
            newCanvas.transform.position = oldCanvas.transform.position;
            newCanvas.transform.rotation = oldCanvas.transform.rotation;
            newCanvas.transform.localScale = oldCanvas.transform.localScale;
        }
    }

    // ���� ������ ��ȯ
    public void SwitchToGameScene()
    {
        SceneManager.LoadScene(gameSceneName);
    }
}
