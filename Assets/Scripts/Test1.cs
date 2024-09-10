using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class test1 : MonoBehaviour
{
    public Canvas test1Canvas;
    public Canvas test2Canvas;

    public void SwitchTotest2()
    {
        test1Canvas.gameObject.SetActive(false);
        test2Canvas.gameObject.SetActive(true);


        test2Canvas.transform.position = test1Canvas.transform.position;
        test2Canvas.transform.rotation = test1Canvas.transform.rotation;
        test2Canvas.transform.localScale = test1Canvas.transform.localScale;
    }
}

