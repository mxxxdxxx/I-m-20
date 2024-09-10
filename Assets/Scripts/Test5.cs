using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class test5 : MonoBehaviour
{
    public Canvas test5Canvas;
    public Canvas levelCanvas;

    public void SwitchTolevel()
    {
        test5Canvas.gameObject.SetActive(false);
        levelCanvas.gameObject.SetActive(true);


        levelCanvas.transform.position = test5Canvas.transform.position;
        levelCanvas.transform.rotation = test5Canvas.transform.rotation;
        levelCanvas.transform.localScale = test5Canvas.transform.localScale;
    }
}

