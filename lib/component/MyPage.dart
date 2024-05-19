import 'package:flutter/material.dart';
import '../const/color.dart';

class mypage extends StatelessWidget {
  const mypage({super.key});

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
            child: Text('마이페이지 입니다',),
          ),
        ),
      ),
         );
  }
}
