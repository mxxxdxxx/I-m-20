import 'package:flutter/material.dart';
import 'package:speakiz/const/color.dart';

class settings extends StatelessWidget {
  const settings({super.key});

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
          child: Center(child: Text('설정페이지 입니다')),),
      ),
    );
  }
}

