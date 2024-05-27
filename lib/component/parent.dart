import 'package:flutter/material.dart';
import '../const/color.dart';
import '../const/text.dart';
import 'feedback.dart';

class parent extends StatefulWidget {
  const parent({Key? key}) : super(key: key);

  @override
  _parentState createState() => _parentState();
}

class _parentState extends State<parent> {
  bool _isPasswordFocused = false;
  final TextEditingController _passwordController = TextEditingController();

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
                    '비밀번호를 입력하세요',
                    style: ts3.copyWith(fontWeight: FontWeight.w700),
                  ),
                  SizedBox(height: 10.0),
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
                    onPressed: () {
                      if (_passwordController.text.isNotEmpty) {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => feedback()),
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
