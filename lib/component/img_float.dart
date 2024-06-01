import 'dart:math';
import 'package:flutter/material.dart';

class FloatingImage extends StatefulWidget {
  final double width;
  final double height;

  const FloatingImage({
    required Key key,
    this.width = 100,
    this.height = 90,
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
      duration: Duration(seconds: 10),
    );

    _animation = Tween<Offset>(
      begin: _randomHorizontalOffset(),
      end: _randomHorizontalOffset(),
    ).animate(_controller);

    _controller.addListener(() {
      setState(() {});
    });

    _controller.addStatusListener((status) {
      if (status == AnimationStatus.completed || status == AnimationStatus.dismissed) {
        _animation = Tween<Offset>(
          begin: _animation.value,
          end: _randomHorizontalOffset(),
        ).animate(_controller);
        _controller.forward(from: 0.0);
      }
    });

    _controller.repeat(reverse: true);
  }

  Offset _randomHorizontalOffset() {
    final random = Random();
    double x = random.nextDouble() * 2 - 1;
    double y = random.nextBool() ? 0 : 0.7;
    return Offset(x, y);
  }



  @override
  Widget build(BuildContext context) {
    return Positioned(
      left: MediaQuery.of(context).size.width * (0.5 + _animation.value.dx / 2),
      top: MediaQuery.of(context).size.height * (0 + _animation.value.dy / 2),
      child: Image.asset(
        'assets/images/cloud.png',
        width: widget.width,
        height: widget.height,
      ),
    );
  }
}