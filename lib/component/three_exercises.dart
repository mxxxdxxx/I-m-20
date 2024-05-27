import 'package:flutter/material.dart';
import 'package:speakiz/component/MyAppBar.dart';
import 'package:speakiz/component/MyDrawer.dart';
import '../component/breath_game.dart';
import '../component/fluent_game.dart';
import '../component/pronunciation_game.dart';
import '../const/color.dart';
import '../const/text.dart';

class ExerciseScreen extends StatefulWidget {
  @override
  State<ExerciseScreen> createState() => _ExerciseScreenState();
}

class _ExerciseScreenState extends State<ExerciseScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: MyDrawer(),
      appBar: MyAppBar(),
      backgroundColor: backColor,
      body: Center(
        child: Column(
          children: [
            Container(
              width: 500.0,
              height: 100.0,
              decoration: BoxDecoration(
                  color: ywColor,
                  borderRadius: BorderRadius.only(
                    topLeft: Radius.circular(40),
                    topRight: Radius.circular(40),
                    bottomLeft: Radius.circular(40),
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.black.withOpacity(0.25),
                      spreadRadius: 0,
                      blurRadius: 5,
                      offset: Offset(2, 2),
                    ),
                  ]),
              child: Center(
                child: Text("오늘의 훈련을 시작해보아요.",
                    textAlign: TextAlign.center,
                    style: ts3.copyWith(fontWeight: FontWeight.w700)),
              ),
            ),
            SizedBox(
              height: 70.0,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                GestureDetector(
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => BreathingExerciseScreen()),
                    );
                  },
                  child: Container(
                    width: 300.0,
                    height: 400.0,
                    decoration: BoxDecoration(
                        color: startColor,
                        borderRadius: BorderRadius.circular(25)),
                    child: Center(
                      child: Text('풍선을 \n 불어보아요.',
                          textAlign: TextAlign.center,
                          style: ts2.copyWith(fontWeight: FontWeight.w700)),
                    ),
                  ),
                ),
                GestureDetector(
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => pronunciationExerciseScreen(),
                      ),
                    );
                  },
                  child: Container(
                    width: 300.0,
                    height: 400.0,
                    decoration: BoxDecoration(
                      color: Color.fromRGBO(0, 169, 255, 0.3),
                      borderRadius: BorderRadius.circular(25),
                    ),
                    child: Center(
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text(
                            '발음을 \n 연습해보아요.',
                            textAlign: TextAlign.center,
                            style: ts2.copyWith(
                              fontWeight: FontWeight.w700,
                            ),
                          ),
                          SizedBox(height: 10),
                          Icon(
                            Icons.lock,
                            size: 80.0,
                            color:
                                Color.fromRGBO(0, 169, 255, 0.8),
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
                GestureDetector(
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => fluentExerciseScreen(),
                      ),
                    );
                  },
                  child: Container(
                    width: 300.0,
                    height: 400.0,
                    decoration: BoxDecoration(
                      color: Color.fromRGBO(0, 169, 255, 0.3),
                      borderRadius: BorderRadius.circular(25),
                    ),
                    child: Center(
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text(
                            '아바타랑 \n 친구가 되어요.',
                            textAlign: TextAlign.center,
                            style: ts2.copyWith(
                              fontWeight: FontWeight.w700,
                            ),
                          ),
                          SizedBox(height: 10),
                          Icon(
                            Icons.lock,
                            size: 80.0,
                            color:
                            Color.fromRGBO(0, 169, 255, 0.8),
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
