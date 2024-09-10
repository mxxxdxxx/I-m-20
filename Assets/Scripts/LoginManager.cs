using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.Networking;

public class LoginManager : MonoBehaviour
{
    public InputField usernameInputField;
    public InputField passwordInputField;
    public Button loginButton;

    private void Start()
    {
        loginButton.onClick.AddListener(OnLoginButtonClick);
    }

    private void OnLoginButtonClick()
    {
        string username = usernameInputField.text;
        string password = passwordInputField.text;
        StartCoroutine(Login(username, password));
    }

    private IEnumerator Login(string username, string password)
    {
        WWWForm form = new WWWForm();
        form.AddField("userName", username); // userName �ʵ� ���
        form.AddField("userPassword", password); // userPassword �ʵ� ���

        UnityWebRequest www = UnityWebRequest.Post("http://localhost:8080/login", form);
        yield return www.SendWebRequest();

        if (www.result != UnityWebRequest.Result.Success)
        {
            Debug.LogError("����: " + www.error);
        }
        else
        {
            Debug.Log("����");
        }
    }
}
