import 'package:flutter/material.dart';
import 'package:speakiz/const/text.dart';

class survey_button extends StatefulWidget {
  final Function(int) onValueSelected;

  survey_button({required this.onValueSelected});

  @override
  _survey_buttonState createState() => _survey_buttonState();
}

class _survey_buttonState extends State<survey_button> {
  int selectedIndex = -1;

  void handleButtonClick(int index) {
    setState(() {
      selectedIndex = index;
    });

    widget.onValueSelected(selectedIndex);
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 500.0,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          ElevatedButton(
            onPressed: () => handleButtonClick(30),
            style: ButtonStyle(
              backgroundColor: selectedIndex == 30
                  ? MaterialStateProperty.all<Color>(Colors.yellow)
                  : null,
            ),
            child: Text(
              '그렇지 않다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  color: Colors.black),
            ),
          ),
          ElevatedButton(
            onPressed: () => handleButtonClick(50),
            style: ButtonStyle(
              backgroundColor: selectedIndex == 50
                  ? MaterialStateProperty.all<Color>(Colors.yellow)
                  : null,
            ),
            child: Text(
              '그런 편이다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  color: Colors.black),
            ),
          ),
          ElevatedButton(
            onPressed: () => handleButtonClick(70),
            style: ButtonStyle(
              backgroundColor: selectedIndex == 70
                  ? MaterialStateProperty.all<Color>(Colors.yellow)
                  : null,
            ),
            child: Text(
              '매우 그렇다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  color: Colors.black),
            ),
          ),
        ],
      ),
    );
  }
}
