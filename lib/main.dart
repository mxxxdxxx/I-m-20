import 'package:flutter/material.dart';
import 'package:speakiz/screen/home_screen.dart';
import 'package:provider/provider.dart';
import 'package:speakiz/component/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => UserProvider(),
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

