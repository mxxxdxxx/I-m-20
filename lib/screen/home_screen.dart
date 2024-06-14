import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:speakiz_im/component/img_float.dart';
import 'package:speakiz_im/screen/login.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/screen/signUp.dart';

class HomeScreen extends StatefulWidget {
  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: startColor,
      body: Stack(
        children: [
          Positioned(
            left: 0,
            right: 0,
            bottom: -135,
            child: Image.asset(
              'assets/images/egg2.png',
              height: 600,
              fit: BoxFit.fitWidth,
            ),
          ),
          Positioned(
            left: (MediaQuery.of(context).size.width - 700) / 2,
            bottom: 130,
            child: SizedBox(
              width: 700,
              height: 60,
              child: ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => Login()),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: navyColor,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(15),
                  ),
                ),
                child: Text(
                  '시작하기',
                  style: ts3w.copyWith(
                    fontWeight: FontWeight.w700,
                  ),
                ),
              ),
            ),
          ),
          ...List.generate(
            10,
                (index) => FloatingImage(key: ValueKey(index)),
          ),
          Positioned(
            left: 0,
            right: 0,
            top: 85,
            child: SvgPicture.asset(
              'assets/images/AppLogo.svg',
              width: 330,
              height: 330,
            ),
          ),
        ],
      ),
    );
  }
}