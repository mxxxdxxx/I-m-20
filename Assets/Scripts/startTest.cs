using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class startTest : MonoBehaviour
{
    public Canvas sufinishCanvas;
    public Canvas test1Canvas;

    public void SwitchTotest1()
    {
        sufinishCanvas.gameObject.SetActive(false);
        test1Canvas.gameObject.SetActive(true);


        test1Canvas.transform.position = sufinishCanvas.transform.position;
        test1Canvas.transform.rotation = sufinishCanvas.transform.rotation;
        test1Canvas.transform.localScale = sufinishCanvas.transform.localScale;
    }
}

