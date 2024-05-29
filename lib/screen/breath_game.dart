import 'package:flutter/material.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'package:speakiz/component/MyAppBar.dart';
import 'package:speakiz/component/MyDrawer.dart';


class BreathingExerciseScreen extends StatefulWidget {
  @override
  State<BreathingExerciseScreen> createState() =>
      _BreathingExerciseScreenState();
}

class _BreathingExerciseScreenState extends State<BreathingExerciseScreen> {
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
                '호흡훈련 화면입니다.',
                style: ts1,
              ),
            ),
          ),
        ],
      ),
    );
  }
}