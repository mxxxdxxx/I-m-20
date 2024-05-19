import 'package:flutter/material.dart';
import '../const/color.dart';
import '../const/text.dart';
import 'textfield.dart';

class parent extends StatelessWidget {
  const parent({super.key});

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
                    size: 50.0,
                    color: navyColor,
                  ),
                  Text(
                    '비밀번호를 입력하세요',
                    style: ts3.copyWith(fontWeight: FontWeight.w700),
                  ),
                  TextFieldScreen(),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
