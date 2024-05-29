import 'package:flutter/material.dart';
import 'package:speakiz/screen/peaki_house.dart';

class peakiButton extends StatefulWidget {
  const peakiButton({super.key});

  @override
  State<peakiButton> createState() => _peakiButtonState();
}

class _peakiButtonState extends State<peakiButton> {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => peaki()),
          );
        },
      child: Container(
        width: 50.0,
        height: 50.0,
        child: Image.asset(
          'assets/images/chicken.png',
          fit: BoxFit.contain,
        ),
      ),
    );
  }
}
