import 'package:flutter/material.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/component/MyAppBar.dart';
import 'package:speakiz_im/component/MyDrawer.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'dart:io';


class BreathingExerciseScreen extends StatefulWidget {
  @override
  State<BreathingExerciseScreen> createState() =>
      _BreathingExerciseScreenState();
}

class _BreathingExerciseScreenState extends State<BreathingExerciseScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // drawer: MyDrawer(),
      // appBar: MyAppBar(),
      backgroundColor: backColor,
      body: Center(
        child: Container(
            width: 1000.0,
            height: 700.0,
            child: breath_game(),
        ),
      ),
    );
  }
}

class breath_game extends StatefulWidget {
  @override
  _breath_gameState createState() => _breath_gameState();
}

class _breath_gameState extends State<breath_game> {
  InAppWebViewController? webView;

  @override
  Widget build(BuildContext context) {
    return InAppWebView(
        initialUrlRequest: URLRequest(url: WebUri('http://localhost:5000/index.html')),
        onWebViewCreated: (InAppWebViewController controller) {
          webView = controller;
        });
  }
}