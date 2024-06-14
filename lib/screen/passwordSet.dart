import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:speakiz_im/screen/situation_choose.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/repository/user_repository.dart';
import 'package:speakiz_im/component/provider.dart';

class PasswordSet extends StatefulWidget {
  const PasswordSet({Key? key}) : super(key: key);

  @override
  _PasswordSetState createState() => _PasswordSetState();
}

class _PasswordSetState extends State<PasswordSet> {
  bool _isPasswordFocused = false;
  final TextEditingController _passwordController = TextEditingController();

  Future<void> _sendParentPassword(int userId) async {
    if (_passwordController.text.isNotEmpty) {
      try {
        await UserRepository().senduserParentPassword(userId, _passwordController.text);
      } catch (e) {
        print('Error setting parent password: $e');
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    final userProvider = Provider.of<UserProvider>(context);
    final user = userProvider.user;

    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Container(
          width: 700.0,
          height: 400.0,
          decoration: BoxDecoration(
            color: ywColor,
            borderRadius: BorderRadius.circular(25),
            boxShadow: [
              BoxShadow(
                color: Colors.black.withOpacity(0.25),
                spreadRadius: 0,
                blurRadius: 10,
                offset: Offset(4, 4),
              ),
            ],
          ),
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(30.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Icon(
                    Icons.lock,
                    size: 60.0,
                    color: navyColor,
                  ),
                  Text(
                    '4자리 숫자로 비밀번호를 설정해주세요.',
                    textAlign: TextAlign.center,
                    style: ts3.copyWith(fontWeight: FontWeight.w700,),
                  ),
                  Text(
                    '아동의 훈련 피드백을 확인할 수 있는 학부모용으로 전환하려면 비밀번호가 필요합니다.',
                    textAlign: TextAlign.center,
                    style: ts1.copyWith(fontSize: 17.0, fontWeight: FontWeight.w700, color: Colors.grey),
                  ),
                  SizedBox(height: 5.0),
                  TextFormField(
                    controller: _passwordController,
                    obscureText: true,
                    textAlign: TextAlign.center,
                    decoration: InputDecoration(
                      hintText: '*  *  *  *',
                      filled: true,
                      fillColor: Colors.white,
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(15.0),
                        borderSide: BorderSide.none,
                      ),
                    ),
                    onChanged: (value) {
                      setState(() {});
                    },
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
                  SizedBox(height: 20.0),
                  ElevatedButton(
                    onPressed: () async {
                      if (user != null && user.userId != null) {
                        await _sendParentPassword(user.userId!);
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => PasswordCheck(userId: user.userId!)),
                        );
                      }
                    },
                    child: Text(
                      '확인',
                      style: ts1w.copyWith(
                        fontWeight: FontWeight.w700,
                      ),
                    ),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                      minimumSize: Size(180.0, 50.0),
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

class PasswordCheck extends StatefulWidget {
  final int userId;

  const PasswordCheck({Key? key, required this.userId}) : super(key: key);

  @override
  _PasswordCheckState createState() => _PasswordCheckState();
}

class _PasswordCheckState extends State<PasswordCheck> {
  String? _parentPassword;

  @override
  void initState() {
    super.initState();
    _fetchParentPassword();
  }

  Future<void> _fetchParentPassword() async {
    try {
      String fetchedPassword = await UserRepository().fetchuserParentPassword(widget.userId);
      setState(() {
        _parentPassword = fetchedPassword;
      });
    } catch (e) {
      print('Error fetching parent password: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Container(
          width: 700.0,
          height: 400.0,
          decoration: BoxDecoration(
            color: ywColor,
            borderRadius: BorderRadius.circular(25),
            boxShadow: [
              BoxShadow(
                color: Colors.black.withOpacity(0.25),
                spreadRadius: 0,
                blurRadius: 10,
                offset: Offset(4, 4),
              ),
            ],
          ),
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(30.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Icon(
                    Icons.lock,
                    size: 60.0,
                    color: navyColor,
                  ),
                  Text(
                    '비밀번호가 다음과 같이 설정되었습니다.',
                    textAlign: TextAlign.center,
                    style: ts3.copyWith(fontWeight: FontWeight.w700,),
                  ),
                  SizedBox(height: 5.0),
                  Text(
                    _parentPassword ?? '불러오는 중...',
                    textAlign: TextAlign.center,
                    style: ts3.copyWith(fontWeight: FontWeight.w700,
                        color: Colors.grey),
                  ),
                  SizedBox(height: 20.0),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Situation()),
                      );
                    },
                    child: Text(
                      '확인',
                      style: ts1w.copyWith(
                        fontWeight: FontWeight.w700,
                      ),
                    ),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                      minimumSize: Size(180.0, 50.0),
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
