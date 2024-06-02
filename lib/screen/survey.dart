import 'package:flutter/material.dart';
import 'package:speakiz/screen/level1.dart';
import 'package:speakiz/component/survey_button.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:provider/provider.dart';
import 'package:speakiz/component/provider.dart';
import 'package:speakiz/model/user.dart';

class test1 extends StatefulWidget {
  const test1({Key? key}) : super(key: key);

  @override
  _test1State createState() => _test1State();
}

class _test1State extends State<test1> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.only(top: 80.0),
          child: Column(
            children: [
              Text(
                '언어 발달 진단테스트',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 30.0,
              ),
              Container(
                  width: 700.0,
                  height: 400.0,
                  decoration: BoxDecoration(
                    color: ywColor,
                    borderRadius: BorderRadius.circular(25),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.25),
                        spreadRadius: 0,
                        blurRadius: 10,
                        offset: Offset(4, 4),
                      ),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.only(top: 50.0),
                    child: Column(
                      children: [
                        Center(
                          child: Stack(
                            alignment: Alignment.center,
                            children: [
                              Container(
                                width: 200,
                                height: 3,
                                color: navyColor,
                              ),
                              SizedBox(height: 20),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                    child: Align(
                                      alignment: Alignment.center,
                                      child: Text(
                                        '1',
                                        style: ts1w.copyWith(
                                            fontWeight: FontWeight.w700),
                                        textAlign: TextAlign.center,
                                      ),
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                ],
                              )
                            ],
                          ),
                        ),
                        SizedBox(
                          height: 30.0,
                        ),
                        Text(
                          '5단어 이상인 문장을 말할 수 있다.',
                          style: ts2.copyWith(fontWeight: FontWeight.w700),
                        ),
                        SizedBox(
                          height: 20.0,
                        ),
                        Text(
                          '“노란 병아리가 알을 깨고 나온다.”',
                          style: ts1.copyWith(
                              fontWeight: FontWeight.w700, color: Colors.grey),
                        ),
                        SizedBox(
                          height: 80.0,
                        ),
                        Container(
                          child: Center(
                            child: survey_button(
                              onValueSelected: (value) {
                                setState(() {
                                  TestValues.selectedValueTest1 = value;
                                });
                              },
                            ),
                          ),
                        ),
                      ],
                    ),
                  )),
              SizedBox(
                height: 40.0,
              ),
              SizedBox(
                width: 180.0,
                height: 60.0,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => test2()),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    child: Text(
                      '다음',
                      style: ts1w.copyWith(fontWeight: FontWeight.w700),
                    )),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class test2 extends StatefulWidget {
  const test2({Key? key}) : super(key: key);

  @override
  _test2State createState() => _test2State();
}

class _test2State extends State<test2> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.only(top: 80.0),
          child: Column(
            children: [
              Text(
                '언어 발달 진단테스트',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 30.0,
              ),
              Container(
                  width: 700.0,
                  height: 400.0,
                  decoration: BoxDecoration(
                    color: ywColor,
                    borderRadius: BorderRadius.circular(25),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.25),
                        spreadRadius: 0,
                        blurRadius: 10,
                        offset: Offset(4, 4),
                      ),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.only(top: 50.0),
                    child: Column(
                      children: [
                        Center(
                          child: Stack(
                            alignment: Alignment.center,
                            children: [
                              Container(
                                width: 200,
                                height: 3,
                                color: navyColor,
                              ),
                              SizedBox(height: 20),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                    child: Align(
                                      alignment: Alignment.center,
                                      child: Text(
                                        '2',
                                        style: ts1w.copyWith(
                                            fontWeight: FontWeight.w700),
                                        textAlign: TextAlign.center,
                                      ),
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                ],
                              )
                            ],
                          ),
                        ),
                        SizedBox(
                          height: 30.0,
                        ),
                        Text(
                          '의문사에 대한 대답을 할 수 있다.',
                          style: ts2.copyWith(fontWeight: FontWeight.w700),
                        ),
                        SizedBox(
                          height: 20.0,
                        ),
                        Text(
                          '“점심 언제 먹었어? 어떤 거 먹었어?”',
                          style: ts1.copyWith(
                              fontWeight: FontWeight.w700, color: Colors.grey),
                        ),
                        SizedBox(
                          height: 80.0,
                        ),
                        Container(
                          child: Center(
                            child: survey_button(
                              onValueSelected: (value) {
                                setState(() {
                                  TestValues.selectedValueTest2 = value;
                                });
                              },
                            ),
                          ),
                        ),
                      ],
                    ),
                  )),
              SizedBox(
                height: 40.0,
              ),
              SizedBox(
                width: 180.0,
                height: 60.0,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => test3()),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    child: Text(
                      '다음',
                      style: ts1w.copyWith(fontWeight: FontWeight.w700),
                    )),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class test3 extends StatefulWidget {
  const test3({Key? key}) : super(key: key);

  @override
  _test3State createState() => _test3State();
}

class _test3State extends State<test3> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.only(top: 80.0),
          child: Column(
            children: [
              Text(
                '언어 발달 진단테스트',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 30.0,
              ),
              Container(
                  width: 700.0,
                  height: 400.0,
                  decoration: BoxDecoration(
                    color: ywColor,
                    borderRadius: BorderRadius.circular(25),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.25),
                        spreadRadius: 0,
                        blurRadius: 10,
                        offset: Offset(4, 4),
                      ),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.only(top: 50.0),
                    child: Column(
                      children: [
                        Center(
                          child: Stack(
                            alignment: Alignment.center,
                            children: [
                              Container(
                                width: 200,
                                height: 3,
                                color: navyColor,
                              ),
                              SizedBox(height: 20),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                    child: Align(
                                      alignment: Alignment.center,
                                      child: Text(
                                        '3',
                                        style: ts1w.copyWith(
                                            fontWeight: FontWeight.w700),
                                        textAlign: TextAlign.center,
                                      ),
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                ],
                              )
                            ],
                          ),
                        ),
                        SizedBox(
                          height: 30.0,
                        ),
                        Text(
                          '겹문장을 사용할 수 있다.',
                          style: ts2.copyWith(fontWeight: FontWeight.w700),
                        ),
                        SizedBox(
                          height: 20.0,
                        ),
                        Text(
                          '“배가 고파서 밥을 먹었어.”',
                          style: ts1.copyWith(
                              fontWeight: FontWeight.w700, color: Colors.grey),
                        ),
                        SizedBox(
                          height: 80.0,
                        ),
                        Container(
                          child: Center(
                            child: survey_button(
                              onValueSelected: (value) {
                                setState(() {
                                  TestValues.selectedValueTest3 = value;
                                });
                              },
                            ),
                          ),
                        ),
                      ],
                    ),
                  )),
              SizedBox(
                height: 40.0,
              ),
              SizedBox(
                width: 180.0,
                height: 60.0,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => test4()),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    child: Text(
                      '다음',
                      style: ts1w.copyWith(fontWeight: FontWeight.w700),
                    )),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class test4 extends StatefulWidget {
  const test4({Key? key}) : super(key: key);

  @override
  _test4State createState() => _test4State();
}

class _test4State extends State<test4> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.only(top: 80.0),
          child: Column(
            children: [
              Text(
                '언어 발달 진단테스트',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 30.0,
              ),
              Container(
                  width: 700.0,
                  height: 400.0,
                  decoration: BoxDecoration(
                    color: ywColor,
                    borderRadius: BorderRadius.circular(25),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.25),
                        spreadRadius: 0,
                        blurRadius: 10,
                        offset: Offset(4, 4),
                      ),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.only(top: 50.0),
                    child: Column(
                      children: [
                        Center(
                          child: Stack(
                            alignment: Alignment.center,
                            children: [
                              Container(
                                width: 200,
                                height: 3,
                                color: navyColor,
                              ),
                              SizedBox(height: 20),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                    child: Align(
                                      alignment: Alignment.center,
                                      child: Text(
                                        '4',
                                        style: ts1w.copyWith(
                                            fontWeight: FontWeight.w700),
                                        textAlign: TextAlign.center,
                                      ),
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: navyColor,
                                    ),
                                  ),
                                ],
                              )
                            ],
                          ),
                        ),
                        SizedBox(
                          height: 30.0,
                        ),
                        Text(
                          '단어의 초성, 받침 등을 생략하지 않고 거의 모든 \n 자음을 정확하게 발음할 수 있다.',
                          textAlign: TextAlign.center,
                          style: ts2.copyWith(fontWeight: FontWeight.w700),
                        ),
                        SizedBox(
                          height: 93.0,
                        ),
                        Container(
                          child: Center(
                            child: survey_button(
                              onValueSelected: (value) {
                                setState(() {
                                  TestValues.selectedValueTest4 = value;
                                });
                              },
                            ),
                          ),
                        ),
                      ],
                    ),
                  )),
              SizedBox(
                height: 40.0,
              ),
              SizedBox(
                width: 180.0,
                height: 60.0,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => test5()),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    child: Text(
                      '다음',
                      style: ts1w.copyWith(fontWeight: FontWeight.w700),
                    )),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class test5 extends StatefulWidget {
  const test5({Key? key}) : super(key: key);

  @override
  _test5State createState() => _test5State();
}

class _test5State extends State<test5> {
  int selectedIndex = -1;

  void handleAnswerSelected(int index) {
    setState(() {
      selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    final userProvider = Provider.of<UserProvider>(context);
    final user = userProvider.user;

    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.only(top: 80.0),
          child: Column(
            children: [
              Text(
                '언어 발달 진단테스트',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 30.0,
              ),
              Container(
                  width: 700.0,
                  height: 400.0,
                  decoration: BoxDecoration(
                    color: ywColor,
                    borderRadius: BorderRadius.circular(25),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.25),
                        spreadRadius: 0,
                        blurRadius: 10,
                        offset: Offset(4, 4),
                      ),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.only(top: 50.0),
                    child: Column(
                      children: [
                        Center(
                          child: Stack(
                            alignment: Alignment.center,
                            children: [
                              Container(
                                width: 200,
                                height: 3,
                                color: navyColor,
                              ),
                              SizedBox(height: 20),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                  ),
                                  SizedBox(width: 10),
                                  Container(
                                    width: 40,
                                    height: 45,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.rectangle,
                                      borderRadius: BorderRadius.circular(20),
                                      color: yellowColor,
                                    ),
                                    child: Align(
                                      alignment: Alignment.center,
                                      child: Text(
                                        '5',
                                        style: ts1w.copyWith(
                                            fontWeight: FontWeight.w700),
                                        textAlign: TextAlign.center,
                                      ),
                                    ),
                                  ),
                                ],
                              )
                            ],
                          ),
                        ),
                        SizedBox(
                          height: 30.0,
                        ),
                        Text(
                          '일정한 높낮이로 문장을 말할 수 있다.',
                          textAlign: TextAlign.center,
                          style: ts2.copyWith(fontWeight: FontWeight.w700),
                        ),
                        SizedBox(
                          height: 130.0,
                        ),
                        Container(
                          child: Center(
                            child: survey_button(
                              onValueSelected: (value) {
                                setState(() {
                                  TestValues.selectedValueTest5 = value;
                                });
                              },
                            ),
                          ),
                        ),
                      ],
                    ),
                  )),
              SizedBox(
                height: 40.0,
              ),
              SizedBox(
                width: 180.0,
                height: 60.0,
                child: ElevatedButton(
                    onPressed: () async {
                      double avr = TestValues.getAverage();
                      print('avr 값: $avr');

                      String level = avr < 50 ? '기초' : '보통';
                      // await TestValues.sendLevel(user?.userId, level);
                      // user와 userId가 null이 아닌지 확인 후 sendLevel()
                      if (user != null && user.userId != null) {
                        int userId = int.parse(user.userId!); // String을 int로 변환
                        await TestValues.sendLevel(userId, level);
                      }

                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => level1()),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: navyColor,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    child: Text(
                      '다음',
                      style: ts1w.copyWith(fontWeight: FontWeight.w700),
                    )),
              )
            ],
          ),
        ),
      ),
    );
  }
}
class TestValues {
  static int selectedValueTest1 = -1;
  static int selectedValueTest2 = -1;
  static int selectedValueTest3 = -1;
  static int selectedValueTest4 = -1;
  static int selectedValueTest5 = -1;

  static double getAverage() {
    return (selectedValueTest1 +
        selectedValueTest2 +
        selectedValueTest3 +
        selectedValueTest4 +
        selectedValueTest5) /
        5;
  }

  // sendLevel userId parameter String? 타입에서 int? 타입으로 변경
  static Future<void> sendLevel(int? userId, String level) async {
    final url = Uri.parse('https://localhost:8080/users/$userId/level');
    final response = await http.post(
      url,
      headers: {
        'Content-Type': 'application/json',
      },
      body: jsonEncode({
        'level': level,
      }),
    );

    if (response.statusCode == 200) {
      print('성공');
    } else {
      print('실패: ${response.statusCode}');
    }
  }
}