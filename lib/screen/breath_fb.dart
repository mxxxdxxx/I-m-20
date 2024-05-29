import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'package:speakiz/component/MyAppBar.dart';
import 'package:speakiz/component/MyDrawer.dart';

class breathFB extends StatefulWidget {
  const breathFB({super.key});

  @override
  State<breathFB> createState() => _breathFBState();
}

class _breathFBState extends State<breathFB> {
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
                '호흡훈련',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 30.0,
              ),
              Container(
                width: 1000.0,
                height: 500.0,
                decoration: BoxDecoration(
                  color: ywColor,
                  borderRadius: BorderRadius.circular(25),
                ),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Container(
                      width: 800.0,
                      height: 150.0,
                      child: Padding(
                        padding: const EdgeInsets.only(left: 100.0),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              '평균 지속시간',
                              style: ts2,
                            ),
                            Container(
                              width: 600,
                              height: 30,
                              color: yellowColor,
                            )
                          ],
                        ),
                      ),
                    ),
                    Container(
                      width: 800.0,
                      height: 150.0,
                      child: Padding(
                        padding: const EdgeInsets.only(left: 100.0),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              '높낮이',
                              style: ts2,
                            ),
                            Container(
                              width: 600,
                              height: 30,
                              color: yellowColor,
                            )
                          ],
                        ),
                      ),
                    ),
                    Container(
                      width: 800.0,
                      height: 150.0,
                      child: Padding(
                        padding: const EdgeInsets.only(left: 100.0),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              '완성한 풍선의 개수',
                              style: ts2,
                            ),
                            Padding(
                              padding: const EdgeInsets.only(left: 100.0),
                              child: Row(
                                children: [
                                  Image.asset('assets/images/balloon.png', scale: 40.0,),
                                  Text(' X   4', style: ts2.copyWith(fontWeight: FontWeight.w700),)
                                ],
                              ),
                            )
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ));
  }
}
