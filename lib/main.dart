import 'package:flutter/material.dart';
import 'package:speakiz_im/screen/home_screen.dart';
import 'package:provider/provider.dart';
import 'package:speakiz_im/component/provider.dart';

void main() {
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => UserProvider()),
      ],
      child: MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          fontFamily: 'roboto',
        ),
        home: HomeScreen(
        ),
    );
  }
}

