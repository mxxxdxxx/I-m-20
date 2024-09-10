using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class test2 : MonoBehaviour
{
    public Canvas test2Canvas;
    public Canvas test3Canvas;

    public void SwitchTotest3()
    {
        test2Canvas.gameObject.SetActive(false);
        test3Canvas.gameObject.SetActive(true);


        test3Canvas.transform.position = test2Canvas.transform.position;
        test3Canvas.transform.rotation = test2Canvas.transform.rotation;
        test3Canvas.transform.localScale = test2Canvas.transform.localScale;
    }
}

