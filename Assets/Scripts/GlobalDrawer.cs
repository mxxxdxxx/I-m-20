using System.Collections;
using UnityEngine;
using UnityEngine.UI;

public class GlobalDrawerController : MonoBehaviour
{
    public static GlobalDrawerController instance;

    public GameObject drawerPanel; // ��ξ� �г�
    public Button closeAreaButton; // ��ξ� �ٱ��� ���� Ŭ�� �� ������ ��ư
    private GameObject currentCanvas; // ���� Ȱ��ȭ�� ĵ����

    private bool isDrawerOpen = false;

    private void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject); // ���� ��ȯ�Ǿ �ı����� �ʵ��� ����
        }
        else
        {
            Destroy(gameObject);
        }
    }

    void Start()
    {
        if (drawerPanel == null)
        {
            Debug.LogError("DrawerPanel�� �������� �ʾҽ��ϴ�.");
        }

        if (closeAreaButton == null)
        {
            Debug.LogError("CloseAreaButton�� �������� �ʾҽ��ϴ�.");
        }

        closeAreaButton.gameObject.SetActive(false);
        closeAreaButton.onClick.AddListener(CloseDrawer);
    }

    public void ToggleDrawer(GameObject callingCanvas)
    {
        // ��ξ �� ������ ���� ĵ������ �ڵ����� ����
        currentCanvas = callingCanvas;

        isDrawerOpen = !isDrawerOpen;
        drawerPanel.SetActive(isDrawerOpen);
        closeAreaButton.gameObject.SetActive(isDrawerOpen);
    }

    public void CloseDrawer()
    {
        isDrawerOpen = false;
        drawerPanel.SetActive(false);
        closeAreaButton.gameObject.SetActive(false);
    }

    public void SwitchCanvas(GameObject targetCanvas)
    {
        if (targetCanvas != null)
        {
            targetCanvas.SetActive(true);
            if (currentCanvas != null)
            {
                currentCanvas.SetActive(false);
            }
            CloseDrawer();
        }
        else
        {
            Debug.LogError("TargetCanvas�� �������� �ʾҽ��ϴ�.");
        }
    }
}
