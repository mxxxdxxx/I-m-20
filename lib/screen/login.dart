import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:speakiz/screen/survey.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

class login extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return LoginScreen();
  }
}

class LoginScreen extends StatefulWidget {
  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _formKey = GlobalKey<FormState>();
  final _usernameController = TextEditingController();
  final _passwordController = TextEditingController();
  bool _isUsernameFocused = false;
  bool _isPasswordFocused = false;

  Future<void> _login() async {
    if (_formKey.currentState!.validate()) {
      final response = await http.post(
        Uri.parse('https://example.com/login'),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(<String, String>{
          'username': _usernameController.text,
          'password': _passwordController.text,
        }),
      );

      if (response.statusCode == 200) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('로그인 성공이다~!~!~!')),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('로그인 실패')),
        );
      }
    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: SingleChildScrollView(
          child: Padding(
            padding: EdgeInsets.all(16.0),
            child: Form(
              key: _formKey,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  SvgPicture.asset(
                    'assets/images/AppLogo.svg',
                    height: 100,
                  ),
                  SizedBox(height: 20),
                  Text(
                    '스피키즈에 오신 걸 환영합니다.',
                    style: ts1.copyWith(fontWeight: FontWeight.w700),
                  ),
                  SizedBox(height: 60),
                  Container(
                    width: 700.0,
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(15),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.black.withOpacity(0.25),
                          spreadRadius: 0,
                          blurRadius: 5,
                          offset: Offset(2, 2),
                        ),
                      ],
                    ),
                    child: TextFormField(
                      controller: _usernameController,
                      decoration: InputDecoration(
                        labelText: !_isUsernameFocused ? 'ID 입력' : null,
                        border: InputBorder.none,
                        contentPadding: EdgeInsets.symmetric(
                            horizontal: 20, vertical: 15),
                      ),
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return '아이디를 입력하세요.';
                        }
                        return null;
                      },
                      onTap: () {
                        setState(() {
                          _isUsernameFocused = true;
                        });
                      },
                      onFieldSubmitted: (_) {
                        setState(() {
                          _isUsernameFocused = false;
                        });
                      },
                    ),
                  ),
                  SizedBox(height: 20),
                  Container(
                    width: 700.0,
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(15),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.black.withOpacity(0.25),
                          spreadRadius: 0,
                          blurRadius: 5,
                          offset: Offset(2, 2),
                        ),
                      ],
                    ),
                    child: TextFormField(
                      controller: _passwordController,
                      decoration: InputDecoration(
                        labelText: !_isPasswordFocused ? '비밀번호 입력' : null,
                        border: InputBorder.none,
                        contentPadding: EdgeInsets.symmetric(
                            horizontal: 20, vertical: 15),
                      ),
                      obscureText: true,
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return '비밀번호를 입력하세요.';
                        }
                        return null;
                      },
                      onTap: () {
                        setState(() {
                          _isPasswordFocused = true;
                        });
                      },
                      onFieldSubmitted: (_) {
                        setState(() {
                          _isPasswordFocused = false;
                        });
                      },
                    ),
                  ),
                  SizedBox(height: 40),
                  SizedBox(
                    height: 60.0,
                    width: 180.0,
                    child: ElevatedButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => test1()),
                        );
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: navyColor,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(15),
                        ),
                      ),
                      child: Text(
                        '로그인',
                        style: ts1w.copyWith(fontWeight: FontWeight.w700),
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 20.0,
                  ),
                  TextButton(
                    onPressed: () {

                    },
                    child: Text(
                      '회원가입',
                      style: TextStyle(
                          color: yellowColor,
                          fontSize: 20.0,
                          fontWeight: FontWeight.bold),
                    ),
                  ),
                  TextButton(
                    onPressed: () {

                    },
                    child: Text(
                      'ID / 비밀번호 찾기',
                      style: TextStyle(
                          color: yellowColor,
                          fontSize: 20.0,
                          fontWeight: FontWeight.bold),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
