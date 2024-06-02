import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:speakiz/component/provider.dart';
import 'package:speakiz/screen/MyPage.dart';
import 'package:speakiz/screen/parent.dart';
import 'package:speakiz/screen/settings.dart';
import 'package:speakiz/const/color.dart';
import 'package:speakiz/const/text.dart';
import 'package:speakiz/screen/information.dart';
import 'package:provider/provider.dart';

class MyDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: <Widget>[
          Container(
            height: 270.0,
            child: DrawerHeader(
              child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Container(
                    width: 150.0,
                    height: 150.0,
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: navyColor,
                    ),
                    child: Image.asset(
                      'assets/images/kid.png',
                      fit: BoxFit.contain,
                    ),
                  ),
                      SizedBox(
                        height: 10.0,
                      ),
                      Text(
                        '김덕우님',
                        style: ts2.copyWith(fontWeight: FontWeight.w700),
                      ),
                  Text(
                    'Level: 기초',
                    style: ts1.copyWith(fontSize: 15.0,fontWeight: FontWeight.w700),
                  ),
                    ],
                  ),
              decoration: BoxDecoration(
                color: yellowColor,
              ),
            ),
          ),
          ListTile(
            title: Text('마이페이지',
              style: ts1.copyWith(fontWeight: FontWeight.w700),),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                    builder: (context) => mypage()),
              );
            },
          ),
          ListTile(
            title: Text('설정',
              style: ts1.copyWith(fontWeight: FontWeight.w700),),
            onTap: () {
              Navigator.push(context,
                MaterialPageRoute(
                    builder: (context) => settings()),
              );

            },
          ),
          ListTile(
            title: Text('학부모용',
              style: ts1.copyWith(fontWeight: FontWeight.w700),),
            onTap: () {
              Navigator.push(context,
                MaterialPageRoute(
                    builder: (context) => parent()),
              );

            },
          ),
          ListTile(
            title: Text('개발정보',
              style: ts1.copyWith(fontWeight: FontWeight.w700),),
            onTap: () {
              Navigator.push(context,
                MaterialPageRoute(
                    builder: (context) => MyApp1()),
              );

            },
          ),
        ],
      ),
    );
  }
}
