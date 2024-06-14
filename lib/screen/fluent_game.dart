import 'package:flutter/material.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/component/MyAppBar.dart';
import 'package:speakiz_im/component/MyDrawer.dart';

class fluentExerciseScreen extends StatefulWidget {
  const fluentExerciseScreen({super.key});

  @override
  State<fluentExerciseScreen> createState() => _fluentExerciseScreenState();
}

class _fluentExerciseScreenState extends State<fluentExerciseScreen> {
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
                '유창성훈련 화면입니다.',
                style: ts1,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
