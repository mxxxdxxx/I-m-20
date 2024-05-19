import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import '../const/color.dart';
import '../const/text.dart';
import 'MyAppBar.dart';
import 'MyDrawer.dart';

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
              SizedBox(
                height: 30.0,
              ),
              Text('호흡훈련',
                style: ts3.copyWith(fontWeight: FontWeight.w700),),
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
                      height: 100.0,
                      child: Center(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text('평균 지속시간',
                            style: ts2,),
                            Container(
                              width: 600,
                              height: 30,
                              color: yellowColor,
                            )
                          ],
                        ),
                      ),
                    ),
                    Expanded(
                      child: Container(
                        width: 800.0,
                        height: 100.0,
                        child: Center(
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text('높낮이',
                                style: ts2,),
                              Container(
                                width: 600,
                                height: 30,
                                color: yellowColor,
                              )
                            ],
                          ),
                        ),
                      ),
                    ),
                    Container(
                      width: 800.0,
                      height: 100.0,
                      child: Center(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text('완성한 풍선의 개수',
                              style: ts2,),
                            Container(
                              width: 600,
                              height: 30,
                              color: yellowColor,
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
        )
    );
  }
}
