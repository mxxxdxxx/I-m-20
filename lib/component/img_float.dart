import 'dart:math';
import 'package:flutter/material.dart';

class FloatingImage extends StatefulWidget {
  final double width;
  final double height;

  const FloatingImage({
    required Key key,
    this.width = 50,
    this.height = 50,
  }) : super(key: key);

  @override
  _FloatingImageState createState() => _FloatingImageState();
}

class _FloatingImageState extends State<FloatingImage>
    with TickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<Offset> _animation;

  @override
  void initState() {
    super.initState();
    _initAnimation();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  void _initAnimation() {
    _controller = AnimationController(
      vsync: this,
      duration: Duration(seconds: 5),
    );

    _animation = Tween<Offset>(
      begin: _randomOffset(),
      end: _randomOffset(),
    ).animate(_controller);

    _controller.addListener(() {
      setState(() {});
    });

    _controller.repeat(reverse: true);
  }

  Offset _randomOffset() {
    final random = Random();
    double x = random.nextDouble() * 2 - 1;
    double y = random.nextDouble() * 2 - 1;
    return Offset(x, y);
  }

  @override
  Widget build(BuildContext context) {
    return Positioned(
      left: MediaQuery.of(context).size.width * (0.5 + _animation.value.dx / 2),
      top: MediaQuery.of(context).size.height * (0.5 + _animation.value.dy / 2),
      child: Image.asset(
        'assets/images/cloud.png',
        width: widget.width,
        height: widget.height,
      ),
    );
  }
}
