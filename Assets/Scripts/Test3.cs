using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class test3 : MonoBehaviour
{
    public Canvas test3Canvas;
    public Canvas test4Canvas;

    public void SwitchTotest4()
    {
        test3Canvas.gameObject.SetActive(false);
        test4Canvas.gameObject.SetActive(true);


        test4Canvas.transform.position = test3Canvas.transform.position;
        test4Canvas.transform.rotation = test3Canvas.transform.rotation;
        test4Canvas.transform.localScale = test3Canvas.transform.localScale;
    }
}

