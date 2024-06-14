import 'package:flutter/material.dart';
import 'package:speakiz_im/component/peaki_button.dart';
import 'package:speakiz_im/const/color.dart';

class MyAppBar extends StatelessWidget implements PreferredSizeWidget {
  @override
  Widget build(BuildContext context) {
    return AppBar(
      backgroundColor: backColor,
      leading: Padding(
        padding: const EdgeInsets.only(left: 8.0),
        child: Builder(
          builder: (BuildContext context) {
            return IconButton(
              icon: Icon(
                Icons.menu,
                size: 50.0,
                color: yellowColor,
              ),
              onPressed: () {
                Scaffold.of(context).openDrawer();
              },
            );
          },
        ),
      ),
      actions: [
        Transform.translate(
          offset: Offset(-8, 4),
          child: Container(
            margin: EdgeInsets.only(right: 10.0),
            child: peakiButton(),
          ),
        ),
      ],
      toolbarHeight: 80.0,
    );
  }

  @override
  Size get preferredSize => Size.fromHeight(80.0);
}
