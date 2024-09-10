using UnityEngine;

public class GlobalCanvasManager : MonoBehaviour
{
    public static GlobalCanvasManager instance;

    private GameObject currentCanvas;

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
    }

    public void SetCurrentCanvas(GameObject canvas)
    {
        currentCanvas = canvas;
    }

    public GameObject GetCurrentCanvas()
    {
        return currentCanvas;
    }
}
