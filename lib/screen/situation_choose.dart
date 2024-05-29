import 'package:flutter/material.dart';
import 'package:speakiz/component/MyAppBar.dart';
import 'package:speakiz/screen/three_exercises.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'package:speakiz/component//MyDrawer.dart';


class Situation extends StatefulWidget {
  const Situation({super.key});

  @override
  State<Situation> createState() => _SituationState();
}

class _SituationState extends State<Situation> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: Drawer(
        child: MyDrawer(),
      ),
      appBar: MyAppBar(),
      backgroundColor: backColor,
      body: Center(
        child: Column(
          children: [
            Container(
              width: 500.0,
              height: 100.0,
              decoration: BoxDecoration(
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
                ],
                color: ywColor,
              ),
              child: Center(
                child: Text("탐험할 장소를 선택해주세요!",
                    textAlign: TextAlign.center,
                    style: ts3.copyWith(fontWeight: FontWeight.w700,)),
              ),
            ),
            SizedBox(
              height: 70.0,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Column(
                  children: [
                    Container(
                      width: 350.0,
                      height: 350.0,
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(180),
                        border: Border.all(color: startColor, width: 15.0),
                        color: navyColor,
                      ),
                      child: Container(
                        width: 350.0,
                        height: 350.0,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(180),
                          border: Border.all(color: backColor, width: 30.0),
                        ),
                        child: GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => ExerciseScreen()),
                            );
                          },
                          child: Image.asset(
                            'assets/images/home.png',
                            scale: 3.0,
                          ),
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 20.0,
                    ),
                    Text('집', style: ts2.copyWith(fontWeight: FontWeight.w700)),
                  ],
                ),
                Column(
                  children: [
                    Container(
                      width: 350.0,
                      height: 350.0,
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(180),
                        border: Border.all(color: startColor, width: 15.0),
                        color: navyColor,
                      ),
                      child: Container(
                        width: 350.0,
                        height: 350.0,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(180),
                          border: Border.all(color: backColor, width: 30.0),
                        ),
                        child: GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => ExerciseScreen()),
                            );
                          },
                          child: Image.asset(
                            'assets/images/school.png',
                            scale: 3.0,
                          ),
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 20.0,
                    ),
                    Text('학교',
                        style: ts2.copyWith(fontWeight: FontWeight.w700)),
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
