using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Level : MonoBehaviour
{
    public Canvas levelCanvas;
    public Canvas placeCanvas;

    public void SwitchToplace()
    {
        levelCanvas.gameObject.SetActive(false);
        placeCanvas.gameObject.SetActive(true);


        placeCanvas.transform.position = levelCanvas.transform.position;
        placeCanvas.transform.rotation = levelCanvas.transform.rotation;
        placeCanvas.transform.localScale = levelCanvas.transform.localScale;
    }
}

