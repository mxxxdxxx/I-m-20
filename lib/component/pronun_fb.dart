import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import '../const/color.dart';
import '../const/text.dart';
import 'MyAppBar.dart';
import 'MyDrawer.dart';

class pronunFB extends StatefulWidget {
  const pronunFB({super.key});

  @override
  State<pronunFB> createState() => _pronunFBState();
}

class _pronunFBState extends State<pronunFB> {
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
              Text('조음훈련',
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
