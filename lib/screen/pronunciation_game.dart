import 'package:flutter/material.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/component/MyAppBar.dart';
import 'package:speakiz_im/component/MyDrawer.dart';

class pronunciationExerciseScreen extends StatefulWidget {
  @override
  State<pronunciationExerciseScreen> createState() =>
      _pronunciationExerciseScreenState();
}

class _pronunciationExerciseScreenState extends State<pronunciationExerciseScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: MyDrawer(),
      appBar: MyAppBar(),
      backgroundColor: backColor,
      body: Column(
        children: [
          Center(
            child: Padding(
              padding: const EdgeInsets.only(top: 250.0),
              child: Text(
                '조음훈련 화면입니다.',
                style: ts1,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
