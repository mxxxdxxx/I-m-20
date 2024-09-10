using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class test4 : MonoBehaviour
{
    public Canvas test4Canvas;
    public Canvas test5Canvas;

    public void SwitchTotest5()
    {
        test4Canvas.gameObject.SetActive(false);
        test5Canvas.gameObject.SetActive(true);


        test5Canvas.transform.position = test4Canvas.transform.position;
        test5Canvas.transform.rotation = test4Canvas.transform.rotation;
        test5Canvas.transform.localScale = test4Canvas.transform.localScale;
    }
}

