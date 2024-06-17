import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:speakiz_im/component/provider.dart';
import 'package:speakiz_im/screen/MyPage.dart';
import 'package:speakiz_im/screen/parent.dart';
import 'package:speakiz_im/screen/settings.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/screen/information.dart';
import 'package:provider/provider.dart';
import 'package:speakiz_im/repository/user_repository.dart';

class MyDrawer extends StatefulWidget {

  @override
  State<MyDrawer> createState() => _MyDrawerState();
}

class _MyDrawerState extends State<MyDrawer> {
  @override
  Widget build(BuildContext context) {
    final userProvider = Provider.of<UserProvider>(context);
    final user = userProvider.user;

    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: <Widget>[
          Container(
            height: 300.0,
            child: DrawerHeader(
              decoration: BoxDecoration(
                color: yellowColor,
              ),
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
                  SizedBox(height: 10.0),
                  Text(
                    '${user?.userName ?? '사용자'}님',
                    style: ts2.copyWith(fontWeight: FontWeight.w700),
                  ),
                  Text(
                    userProvider.userLevelText,
                    style: ts1.copyWith(fontSize: 15.0, fontWeight: FontWeight.w700),
                  ),
                ],
              ),
            ),
          ),
          ListTile(
            title: Text(
              '마이페이지',
              style: ts1.copyWith(fontWeight: FontWeight.w700),
            ),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => mypage()),
              );
            },
          ),
          ListTile(
            title: Text(
              '설정',
              style: ts1.copyWith(fontWeight: FontWeight.w700),
            ),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => settings()),
              );
            },
          ),
          ListTile(
            title: Text(
              '학부모용',
              style: ts1.copyWith(fontWeight: FontWeight.w700),
            ),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => parent()),
              );
            },
          ),
          ListTile(
            title: Text(
              '개발정보',
              style: ts1.copyWith(fontWeight: FontWeight.w700),
            ),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => MyApp1()),
              );
            },
          ),
        ],
      ),
    );
  }
}
