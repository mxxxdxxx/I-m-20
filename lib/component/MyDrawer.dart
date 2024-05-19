import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:speakiz/component/MyPage.dart';
import 'package:speakiz/component/parent.dart';
import 'package:speakiz/component/settings.dart';
import '../const/color.dart';
import '../const/text.dart';
import '../main.dart';
import 'information.dart';

class MyDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: <Widget>[
          Container(
            height: 250.0,
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
                        style: ts1.copyWith(fontWeight: FontWeight.w700),
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
          // 원하는 만큼 메뉴 아이템 추가
        ],
      ),
    );
  }
}
