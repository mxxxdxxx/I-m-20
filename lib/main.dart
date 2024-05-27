import 'package:flutter/material.dart';
import 'screen/home_screen.dart';


void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          fontFamily: 'roboto',
        ),
        home: HomeScreen(
        ),
      ),
    );
  }
}

