import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:speakiz/component/survey.dart';
import '../component/img_float.dart';
import '../component/login.dart';
import '../const/color.dart';
import '../const/text.dart';

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
            left: 0,
            right: 0,
            top: 85,
            child: SvgPicture.asset(
              'assets/images/AppLogo.svg',
              width: 330,
              height: 330,
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
                    MaterialPageRoute(builder: (context) => login()),
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
                  )
                ),
              ),
            ),
          ),
          ...List.generate(50, (index) => FloatingImage(key: ValueKey(index)),

          )],
      ),
    );
  }
}




