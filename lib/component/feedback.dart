import 'package:flutter/material.dart';
import 'package:speakiz/component/pronun_fb.dart';
import '../const/color.dart';
import '../const/text.dart';
import 'MyAppBar.dart';
import 'MyDrawer.dart';
import 'breath_fb.dart';
import 'chart.dart';
import 'fluent_fb.dart';

class feedback extends StatefulWidget {
  const feedback({super.key});

  @override
  State<feedback> createState() => _feedbackState();
}

class _feedbackState extends State<feedback> {
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
            Text(
              '김덕우의 기록',
              style: ts3.copyWith(fontWeight: FontWeight.w700),
            ),
            SizedBox(
              height: 30.0,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Column(
                  children: [
                    Container(
                      width: 400.0,
                      height: 200.0,
                      decoration: BoxDecoration(
                        color: ywColor,
                        borderRadius: BorderRadius.circular(15),
                        boxShadow: [
                          BoxShadow(
                            color: Colors.black.withOpacity(0.25),
                            spreadRadius: 0,
                            blurRadius: 1,
                            offset: Offset(1, 1),
                          ),
                        ],
                      ),
                      child: LineChartSample(),
                    ),
                    TextButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => breathFB(),),
                        );
                      },
                      child: Text(
                        '호흡훈련',
                        style: ts1.copyWith(
                          fontWeight: FontWeight.w700,
                          fontSize: 20.0,
                          color: navyColor,
                        ),
                      ),
                    ),
                  ],
                ),
                SizedBox(
                  width: 30.0,
                ),
                Column(
                  children: [
                    Container(
                      width: 400.0,
                      height: 200.0,
                      decoration: BoxDecoration(
                        color: ywColor,
                        borderRadius: BorderRadius.circular(25),
                        boxShadow: [
                          BoxShadow(
                            color: Colors.black.withOpacity(0.25),
                            spreadRadius: 0,
                            blurRadius: 1,
                            offset: Offset(1, 1),
                          ),
                        ],
                      ),
                    ),
                    TextButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => pronunFB(),),
                        );
                      },
                      child: Text(
                        '조음훈련',
                        style: ts1.copyWith(
                          fontWeight: FontWeight.w700,
                          fontSize: 20.0,
                          color: navyColor,
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
            Column(
              children: [
                Container(
                  width: 830.0,
                  height: 250.0,
                  decoration: BoxDecoration(
                    color: ywColor,
                    borderRadius: BorderRadius.circular(25),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.25),
                        spreadRadius: 0,
                        blurRadius: 1,
                        offset: Offset(1, 1),
                      ),
                    ],
                  ),
                ),
                TextButton(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => fluentFB(),),
                    );
                  },
                  child: Text(
                    '유창성훈련',
                    style: ts1.copyWith(
                      fontWeight: FontWeight.w700,
                      fontSize: 20.0,
                      color: navyColor,
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
