using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class start : MonoBehaviour
{
    public Canvas startCanvas; 
    public Canvas loginCanvas; 

    public void SwitchTologin()
    {
        startCanvas.gameObject.SetActive(false);
        loginCanvas.gameObject.SetActive(true); 

        
        loginCanvas.transform.position = startCanvas.transform.position;
        loginCanvas.transform.rotation = startCanvas.transform.rotation;
        loginCanvas.transform.localScale = startCanvas.transform.localScale;
    }
}

