// import 'package:flutter/material.dart';
//
// import '../const/color.dart';
//
// class info extends StatelessWidget {
//   const info({super.key});
//
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       backgroundColor: backColor,
//       body: Center(
//         child: Container(
//             width: 700.0,
//             height: 400.0,
//             decoration: BoxDecoration(
//               color: ywColor,
//               borderRadius: BorderRadius.circular(25),
//               boxShadow: [
//                 BoxShadow(
//                   color: Colors.black.withOpacity(0.25),
//                   spreadRadius: 0,
//                   blurRadius: 10,
//                   offset: Offset(4, 4),
//                 ),
//               ],
//             ),
//           child: Center(child: Text('개발정보 입니다')),),
//       ),
//     );
//   }
// }

import 'dart:async';
import 'dart:math';

import 'package:confetti/confetti.dart';
import 'package:flutter/material.dart';

class ConfettiSample extends StatelessWidget {
  const ConfettiSample({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Confetti',
      home: Scaffold(
        backgroundColor: Colors.grey[900],
        body: MyApp1(),
      ),
    );
  }
}

class MyApp1 extends StatefulWidget {
  @override
  _MyApp1State createState() => _MyApp1State();
}

class _MyApp1State extends State<MyApp1> {
  late ConfettiController _controllerCenter;

  @override
  void initState() {
    super.initState();
    _controllerCenter = ConfettiController(duration: const Duration(seconds: 10));
    _startConfetti();
  }

  @override
  void dispose() {
    _controllerCenter.dispose();
    super.dispose();
  }

  void _startConfetti() {
    // 일정 시간이 지난 후 Confetti 효과 시작
    Timer(Duration(milliseconds: 500), () {
      _controllerCenter.play();
    });
  }

  Path drawHeart(Size size) {
    double width = size.width;
    double height = size.height;

    Path path = Path();

    path.moveTo(0.5 * width, height * 0.35);
    path.cubicTo(0.2 * width, height * 0.1, -0.25 * width, height * 0.6,
        0.5 * width, height);
    path.moveTo(0.5 * width, height * 0.35);
    path.cubicTo(0.8 * width, height * 0.1, 1.25 * width, height * 0.6,
        0.5 * width, height);

    path.close();
    return path;
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Stack(
        children: <Widget>[
          //CENTER -- Blast
          Align(
            alignment: Alignment.center,
            child: ConfettiWidget(
              confettiController: _controllerCenter,
              blastDirectionality: BlastDirectionality.explosive,
              shouldLoop: true,
              colors: const [
                Colors.green,
                Colors.blue,
                Colors.pink,
                Colors.orange,
                Colors.purple
              ],
              createParticlePath: drawHeart,
            ),
          ),
          Align(
            alignment: Alignment.center,
            child: TextButton(
              onPressed: () {
                _controllerCenter.play();
              },
              child: _display('blast\nHearts'),
            ),
          ),
        ],
      ),
    );
  }

  Text _display(String text) {
    return Text(
      text,
      style: const TextStyle(color: Colors.white, fontSize: 20),
    );
  }
}

void main() {
  runApp(ConfettiSample());
}
