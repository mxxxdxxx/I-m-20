using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CanvasSwitcher : MonoBehaviour
{
    public GameObject placeCanvas;
    public GameObject training1Canvas;
    public GameObject training2Canvas;

    public void ShowTraining1Canvas()
    {
        placeCanvas.SetActive(false);
        training1Canvas.SetActive(true);
    }

    public void ShowTraining2Canvas()
    {
        placeCanvas.SetActive(false);
        training2Canvas.SetActive(true);
    }

    public void ShowPlaceCanvas()
    {
        placeCanvas.SetActive(true);
        training1Canvas.SetActive(false);
        training2Canvas.SetActive(false);
    }
}
