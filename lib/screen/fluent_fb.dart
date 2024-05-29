import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'package:speakiz/component/MyAppBar.dart';
import 'package:speakiz/component/MyDrawer.dart';

class fluentFB extends StatefulWidget {
  const fluentFB({super.key});

  @override
  State<fluentFB> createState() => _fluentFBState();
}

class _fluentFBState extends State<fluentFB> {
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
              Text('유창성훈련',
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

              ),
            ],
          ),
        )
    );
  }
}
