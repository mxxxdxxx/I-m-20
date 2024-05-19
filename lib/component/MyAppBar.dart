import 'package:flutter/material.dart';
import 'package:speakiz/component/peaki_button.dart';

import '../const/color.dart';

class MyAppBar extends StatelessWidget implements PreferredSizeWidget {

  @override
  Widget build(BuildContext context) {
    return AppBar(
      backgroundColor: backColor,
      leading: Padding(
        padding: const EdgeInsets.only(left: 10.0),
        child: Builder(
          builder: (BuildContext context) {
            return IconButton(
              icon: Icon(
                Icons.menu,
                size: 50.0,
                color: yellowColor,
              ),
              onPressed: (){
                Scaffold.of(context).openDrawer();
              },
            );
          },
        ),
      ),
      actions: [
        Container(
          margin: EdgeInsets.only(right: 10.0, top: 10.0),
          child: peakiButton(),
        ),
      ],
    );
  }

  @override
  Size get preferredSize => Size.fromHeight(kToolbarHeight);


}
