import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:speakiz_im/screen/passwordSet.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:flutter/material.dart';
import 'package:speakiz_im/component/provider.dart';
import 'package:speakiz_im/repository/user_repository.dart';

class level1 extends StatefulWidget {
  final int userLevel;
  const level1({Key? key, required this.userLevel}) : super(key: key);

  @override
  State<level1> createState() => _level1State();
}

class _level1State extends State<level1> {
  @override
  Widget build(BuildContext context) {
    final userLevelText = UserRepository().getUserLevelText(widget.userLevel);

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
                padding: const EdgeInsets.symmetric(horizontal: 40.0),
                child: Row(
                  children: [
                    Container(
                      width: 159.0,
                      height: 159.0,
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        color: navyColor,
                      ),
                      child: Image.asset('assets/images/kid.png'),
                    ),
                    SizedBox(width: 30.0,),
                    Text('우리 아이의 언어 발달 수준은 ${userLevelText} 단계입니다. \n\n 호흡훈련, 조음 훈련, AI아바타를 활용한 유창성 \n 훈련으로 아이의 말하기 실력이 향상될 수\n 있도록 꾸준한 지도 바랍니다. \n\n 위 설문은 훈련 30회차가 완료된 후 다시 한 번 \n 진행됩니다.',
                    textAlign: TextAlign.start,
                    style: ts1.copyWith(
                      fontWeight: FontWeight.w700
                    ),),
                  ],
                ),
              ),
            ),
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
                          MaterialPageRoute(builder: (context) => PasswordSet(),),
                        );
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: navyColor,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(15),
                        ),
                      ),
                      child: Text(
                        '확인',
                        style: ts1w.copyWith(fontWeight: FontWeight.w700),
                      )),
                )
          ]),
        ),
      ),
    );
  }
}
