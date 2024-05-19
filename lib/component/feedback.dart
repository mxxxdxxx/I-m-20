import 'package:fl_chart/fl_chart.dart';
import 'package:flutter/material.dart';
import '../component/situation_choose.dart';
import '../const/color.dart';
import '../const/text.dart';
import 'MyAppBar.dart';
import 'MyDrawer.dart';
import 'breath_fb.dart';

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
                  child: TextButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => breathFB()),
                        );
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: navyColor,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(15),
                        ),
                      ),
                      child: Text(
                        '호흡훈련',
                        style: ts1w.copyWith(fontWeight: FontWeight.w700),
                      )
                  ),
                ),
                SizedBox(
                  width: 30.0,
                ),
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
                      ]),
                ),
              ],
            ),
            SizedBox(
              height: 30.0,
            ),
            Container(
              width: 800.0,
              height: 300.0,
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
                  ]),
            )
          ],
        ),
      ),
    );
  }
}
