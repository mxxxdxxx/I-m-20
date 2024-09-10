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
        form.AddField("userName", username); // userName 필드 사용
        form.AddField("userPassword", password); // userPassword 필드 사용

        UnityWebRequest www = UnityWebRequest.Post("http://localhost:8080/login", form);
        yield return www.SendWebRequest();

        if (www.result != UnityWebRequest.Result.Success)
        {
            Debug.LogError("실패: " + www.error);
        }
        else
        {
            Debug.Log("성공");
        }
    }
}
