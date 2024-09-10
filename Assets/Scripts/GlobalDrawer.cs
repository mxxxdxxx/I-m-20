using System.Collections;
using UnityEngine;
using UnityEngine.UI;

public class GlobalDrawerController : MonoBehaviour
{
    public static GlobalDrawerController instance;

    public GameObject drawerPanel; // 드로어 패널
    public Button closeAreaButton; // 드로어 바깥쪽 영역 클릭 시 닫히는 버튼
    private GameObject currentCanvas; // 현재 활성화된 캔버스

    private bool isDrawerOpen = false;

    private void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject); // 씬이 전환되어도 파괴되지 않도록 설정
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
            Debug.LogError("DrawerPanel이 설정되지 않았습니다.");
        }

        if (closeAreaButton == null)
        {
            Debug.LogError("CloseAreaButton이 설정되지 않았습니다.");
        }

        closeAreaButton.gameObject.SetActive(false);
        closeAreaButton.onClick.AddListener(CloseDrawer);
    }

    public void ToggleDrawer(GameObject callingCanvas)
    {
        // 드로어를 열 때마다 현재 캔버스를 자동으로 설정
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
            Debug.LogError("TargetCanvas가 설정되지 않았습니다.");
        }
    }
}
