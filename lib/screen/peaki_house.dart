import 'package:flutter/material.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';

class peaki extends StatefulWidget {
  const peaki({super.key});

  @override
  State<peaki> createState() => _peakiState();
}

class _peakiState extends State<peaki> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Padding(
        padding: const EdgeInsets.only(top: 100.0),
        child: Column(
          children: [
            Text(
              '피키의 집',
              style: ts3.copyWith(
                fontWeight: FontWeight.w700
              ),
            ),
            SizedBox(
              height: 100.0,
            ),
            Center(
                child: Image.asset(
                  'assets/images/chicken.png',
                  scale: 2.0,
                )),
          ],
        ),
      ),
    );
  }
}