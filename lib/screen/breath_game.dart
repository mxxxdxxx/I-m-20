import 'package:flutter/material.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/component/MyAppBar.dart';
import 'package:speakiz_im/component/MyDrawer.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

class BreathingExerciseScreen extends StatefulWidget {
  @override
  State<BreathingExerciseScreen> createState() => _BreathingExerciseScreenState();
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
          width: MediaQuery.of(context).size.width,
          height: MediaQuery.of(context).size.height,
          child: BreathGame(),
        ),
      ),
    );
  }
}

class BreathGame extends StatefulWidget {
  @override
  _BreathGameState createState() => _BreathGameState();
}

class _BreathGameState extends State<BreathGame> {
  InAppWebViewController? webView;

  void logToServer(String message) async {
    var url = Uri.parse('http://172.20.1.49:8000/log');
    var response = await http.post(
      url,
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode({'message': message}),
    );
    print('Log sent to server: ${response.statusCode}');
  }

  @override
  Widget build(BuildContext context) {
    return InAppWebView(
      initialUrlRequest: URLRequest(
        url: WebUri('http://172.20.1.49:5000/index.html'), // 서버 노트북의 IP 주소 사용
      ),
      onWebViewCreated: (InAppWebViewController controller) {
        webView = controller;
      },
      onReceivedError: (controller, request, error) {
        logToServer('Load error: ${error.description}');
      },
      onReceivedHttpError: (controller, request, response) {
        logToServer('HTTP error: ${response.statusCode} ${response.reasonPhrase}');
      },
      onConsoleMessage: (controller, consoleMessage) {
        logToServer('Console message: ${consoleMessage.message}');
      },
      androidOnPermissionRequest: (controller, origin, resources) async {
        return PermissionRequestResponse(
          resources: resources,
          action: PermissionRequestResponseAction.GRANT,
        );
      },
    );
  }
}

