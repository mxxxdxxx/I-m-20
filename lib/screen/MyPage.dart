import 'package:flutter/material.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';

class mypage extends StatelessWidget {
  const mypage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: backColor,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
                width: 700.0,
                height: 330.0,
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
                      width: 200.0,
                      height: 200.0,
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        color: navyColor,
                      ),
                      child: Image.asset('assets/images/kid.png',
                        scale: 0.1,),
                    ),
                    SizedBox(
                      width: 20.0,
                    ),
                    Container(
                      width: 400.0,
                      child: Center(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text('김덕우',
                            style: ts3.copyWith(
                              decoration: TextDecoration.underline,
                            ),),
                            SizedBox(
                              height: 10.0,
                            ),
                            Text('dukwoo1234',
                              style: ts3.copyWith(
                                decoration: TextDecoration.underline,
                              ),),
                            SizedBox(
                              height: 10.0,
                            ),
                            Text('dukwoo@naver.com',
                              style: ts3.copyWith(
                                decoration: TextDecoration.underline,
                              ),),
                          ],
                        ),
                      ),
                    )
                  ],
                ),
              )
            ),
            SizedBox(
              height: 50.0,
            ),
            ElevatedButton(
              onPressed: () {
              },
              child: Text(
                '비밀번호 변경',
                style: ts1w.copyWith(
                  fontWeight: FontWeight.w700,
                ),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: navyColor,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(15),
                ),
                minimumSize: Size(180.0, 50.0),
              ),
            ),
            SizedBox(
              height: 20.0,
            ),
            ElevatedButton(
              onPressed: () {
              },
              child: Text(
                '로그아웃',
                style: ts1w.copyWith(
                  fontWeight: FontWeight.w700,
                ),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: navyColor,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(15),
                ),
                minimumSize: Size(180.0, 50.0),
              ),
            ),
            SizedBox(
              height: 20.0,
            ),
            ElevatedButton(
              onPressed: () {
              },
              child: Text(
                '회원탈퇴',
                style: ts1w.copyWith(
                  fontWeight: FontWeight.w700,
                ),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: navyColor,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(15),
                ),
                minimumSize: Size(180.0, 50.0),
              ),
            ),
          ],
        ),

      ),
         );
  }
}
