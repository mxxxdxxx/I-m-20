import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:speakiz/component/provider.dart';
import 'package:speakiz/model/user.dart';
import 'package:speakiz/repository/user_repository.dart';
import 'package:speakiz/screen/survey.dart';
import 'home_screen.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';

class Login extends StatelessWidget {
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
  final _idController = TextEditingController();
  final _passwordController = TextEditingController();
  bool _isIdFocused = false;
  bool _isPasswordFocused = false;
  final UserRepository userRepository = UserRepository(baseUrl: 'http://10.0.2.2:8080');

  Future<User?>? _loginFuture;

  Future<User?> _login() async {
    print('로그인 버튼이 눌렸습니다.');
    if (_formKey.currentState!.validate()) {
      try {
        print('로그인 시도중...');
        final user = await userRepository.login(
          _idController.text,
          _passwordController.text,
        );

        if (user != null) {
          print('로그인 성공: ${user.userLoginId}');
          return user;
        } else {
          print('로그인 실패: 사용자 정보가 null입니다.');
          return null;
        }
      } catch (e) {
        print('Error during login: $e');
        return null;
      }
    } else {
      print('Form validation failed');
      return null;
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
                      controller: _idController,
                      decoration: InputDecoration(
                        labelText: !_isIdFocused ? 'ID 입력' : null,
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
                          _isIdFocused = true;
                        });
                      },
                      onFieldSubmitted: (_) {
                        setState(() {
                          _isIdFocused = false;
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
                        print('Login button pressed');
                        setState(() {
                          _loginFuture = _login();
                        });
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
                  _loginFuture == null
                      ? Container()
                      : FutureBuilder<User?>(
                    future: _loginFuture,
                    builder: (context, snapshot) {
                      if (snapshot.connectionState == ConnectionState.waiting) {
                        return Center(child: CircularProgressIndicator());
                      } else if (snapshot.hasError) {
                        return Center(child: Text('Error: ${snapshot.error}'));
                      } else if (snapshot.hasData) {
                        if (snapshot.data != null) {

                          WidgetsBinding.instance.addPostFrameCallback((_) {
                            Navigator.pushReplacement(
                              context,
                              MaterialPageRoute(builder: (context) => test1()),
                            );
                          });
                          return Container();
                        } else {
                          print('응답없음');
                          return Container();
                        }
                      } else {
                        print('응답없음');
                        return Container();
                      }
                    },
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
