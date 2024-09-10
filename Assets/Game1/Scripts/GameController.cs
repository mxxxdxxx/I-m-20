using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement; // �� ���� ���ӽ����̽� �߰�

public class GameController : MonoBehaviour
{
    public GameObject gameSuccessUI; // ���� ���� UI ����
    public GameObject gameFailUI; // ���� ���� UI ����
    public Mic micScript; // Mic ��ũ��Ʈ ����
    public Text attemptsText; // ���� ���� UI�� ǥ���� Attempts Text ����
    public Text failAttemptsText; // ���� ���� UI�� ǥ���� Attempts Text ����
    public Text successBalloonsText; // ������ ǳ�� ������ ǥ���� Text ����

    public GameObject image1; // ������ ǳ�� 1���� �� Ȱ��ȭ�� �̹���
    public GameObject image2; // ������ ǳ�� 2���� �� Ȱ��ȭ�� �̹���
    public GameObject image3; // ������ ǳ�� 3���� �� Ȱ��ȭ�� �̹���
    public GameObject image4; // ������ ǳ�� 4���� �� Ȱ��ȭ�� �̹���

    void Start()
    {
        gameSuccessUI.SetActive(false); // ���� ���� �� ���� UI ����
        gameFailUI.SetActive(false); // ���� ���� �� ���� UI ����
        
        // ��� �̹����� ��Ȱ��ȭ
        image1.SetActive(false);
        image2.SetActive(false);
        image3.SetActive(false);
        image4.SetActive(false);
    }

    void Update()
    {
        CheckEndGameCondition();
        UpdateSuccessImages(); // ������ ǳ�� ������ ���� �̹��� ������Ʈ
    }

    public void CheckEndGameCondition()
    {
        // Mic ��ũ��Ʈ�� spheres ����Ʈ�� �����Ͽ� 5���� �Ǿ����� Ȯ��
        if (micScript.GetSphereCount() >= 5)
        {
            gameSuccessUI.SetActive(true); // ���� ���� UI Ȱ��ȭ
            attemptsText.text = micScript.totalAttempts.ToString() + " ȸ";
            micScript.enabled = false; // Mic ��ũ��Ʈ ��Ȱ��ȭ
        }

        // �õ� Ƚ���� 10���� �ʰ��ϸ� ���� UI Ȱ��ȭ
        else if (micScript.totalAttempts >= 10)
        {
            gameFailUI.SetActive(true); // ���� ���� UI Ȱ��ȭ
            failAttemptsText.text = micScript.totalAttempts.ToString() + " ȸ"; // �õ� Ƚ�� ������Ʈ
            successBalloonsText.text = "���� ǳ�� ���� : "; // ������ ǳ�� ���� ������Ʈ
            micScript.enabled = false; // Mic ��ũ��Ʈ ��Ȱ��ȭ
        }
    }

    public void UpdateSuccessImages()
    {
        // ��� �̹����� ��Ȱ��ȭ
        image1.SetActive(false);
        image2.SetActive(false);
        image3.SetActive(false);
        image4.SetActive(false);

        // ������ ǳ�� ������ ���� �ش� �̹��� �ϳ��� Ȱ��ȭ
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
        // ���� ���� �ٽ� �ε��Ͽ� ������ �����
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }
}
