using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class signUpNext : MonoBehaviour
{
    public Canvas signUpCanvas;
    public Canvas sufinishCanvas;

    public void SwitchTosufinish()
    {
        signUpCanvas.gameObject.SetActive(false);
        sufinishCanvas.gameObject.SetActive(true);


        sufinishCanvas.transform.position = signUpCanvas.transform.position;
        sufinishCanvas.transform.rotation = signUpCanvas.transform.rotation;
        sufinishCanvas.transform.localScale = signUpCanvas.transform.localScale;
    }
}

