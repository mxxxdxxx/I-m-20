import 'package:flutter/material.dart';
import 'package:speakiz_im/const/text.dart';

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
      width: 700.0,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          ElevatedButton(
            onPressed: () => handleButtonClick(10),
            style: ButtonStyle(
              backgroundColor: selectedIndex == 10
                  ? MaterialStateProperty.all<Color>(Colors.yellow)
                  : null,
            ),
            child: Text(
              '매우 그렇지 않다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  fontSize: 17.0,
                  color: Colors.black),
            ),
          ),
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
                  fontSize: 17.0,
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
              '보통이다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  fontSize: 17.0,
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
              '그렇다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  fontSize: 17.0,
                  color: Colors.black),
            ),
          ),
          ElevatedButton(
            onPressed: () => handleButtonClick(90),
            style: ButtonStyle(
              backgroundColor: selectedIndex == 90
                  ? MaterialStateProperty.all<Color>(Colors.yellow)
                  : null,
            ),
            child: Text(
              '매우 그렇다',
              style: ts1.copyWith(
                  fontWeight: FontWeight.w700,
                  fontSize: 17.0,
                  color: Colors.black),
            ),
          ),
        ],
      ),
    );
  }
}
