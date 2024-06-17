import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:speakiz_im/const/color.dart';
import 'package:speakiz_im/const/text.dart';
import 'package:speakiz_im/component/MyAppBar.dart';
import 'package:speakiz_im/component/MyDrawer.dart';
import 'package:fl_chart/fl_chart.dart';

class breathFB extends StatefulWidget {
  const breathFB({super.key});

  @override
  State<breathFB> createState() => _breathFBState();
}

class _breathFBState extends State<breathFB> {
  List<double> averageDurations = [2.5, 2.8, 2.9, 2.7, 2.6]; // 3초 기준 임시 데이터
  List<double> soundLevels = [0.0, 0.8, 1.2, 1.0, 0.9, 1.1, 1.3]; // 임시 소리 크기 데이터

  double calculateAverage() {
    double sum = averageDurations.fold(0, (a, b) => a + b);
    return sum / averageDurations.length;
  }

  @override
  Widget build(BuildContext context) {
    double averageDuration = calculateAverage();

    return Scaffold(
      drawer: Drawer(
        child: MyDrawer(),
      ),
      appBar: MyAppBar(),
      backgroundColor: backColor,
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            children: [
              Text(
                '호흡훈련',
                style: ts3.copyWith(fontWeight: FontWeight.w700),
              ),
              SizedBox(
                height: 20.0,
              ),
              Container(
                width: 1000.0,
                height: 600.0,
                decoration: BoxDecoration(
                  color: ywColor,
                  borderRadius: BorderRadius.circular(25),
                ),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Container(
                      width: 800.0,
                      height: 120.0,
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            '평균 지속시간',
                            style: ts2,
                          ),
                          SizedBox(height: 10),
                          Column(
                            crossAxisAlignment: CrossAxisAlignment.end,
                            children: [
                              Text(
                                '3초',
                                textAlign: TextAlign.end,
                                style: TextStyle(
                                  color: Colors.black,
                                  fontWeight: FontWeight.bold,
                                  fontSize: 14,
                                ),
                              ),
                              Stack(
                                children: [
                                  Container(
                                    width: 600,
                                    height: 30,
                                    decoration: BoxDecoration(
                                      color: Colors.grey[200],
                                      borderRadius: BorderRadius.circular(15),
                                    ),
                                  ),
                                  Container(
                                    width: 600 * (averageDuration / 3), // 최대 3초 기준
                                    height: 30,
                                    decoration: BoxDecoration(
                                      color: yellowColor,
                                      borderRadius: BorderRadius.circular(15),
                                    ),
                                    child: Align(
                                      alignment: Alignment.centerRight,
                                      child: Padding(
                                        padding: const EdgeInsets.only(right: 10),
                                        child: Text(
                                          '${averageDuration.toStringAsFixed(1)}초',
                                          style: TextStyle(
                                            color: Colors.black,
                                            fontWeight: FontWeight.bold,
                                            fontSize: 14,
                                          ),
                                        ),
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ],
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(vertical: 0, horizontal: 100.0),
                      child: Container(
                        width: 800,
                        height: 190,
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              '성량',
                              style: ts2,
                            ),
                            SizedBox(height: 10),
                            Container(
                              width: 800,
                              height: 140,
                              child: LineChart(
                                LineChartData(
                                  gridData: FlGridData(show: false),
                                  titlesData: FlTitlesData(
                                    leftTitles: AxisTitles(
                                      sideTitles: SideTitles(showTitles: false),
                                    ),
                                    rightTitles: AxisTitles(
                                      sideTitles: SideTitles(showTitles: false),
                                    ),
                                    topTitles: AxisTitles(
                                      sideTitles: SideTitles(showTitles: false),
                                    ),
                                    bottomTitles: AxisTitles(
                                      sideTitles: SideTitles(
                                        showTitles: true,
                                        interval: 1,
                                        getTitlesWidget: (value, meta) {
                                          switch (value.toInt()) {
                                            case 0:
                                              return Text('0s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            case 1:
                                              return Text('0.5s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            case 2:
                                              return Text('1s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            case 3:
                                              return Text('1.5s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            case 4:
                                              return Text('2s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            case 5:
                                              return Text('2.5s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            case 6:
                                              return Text('3s', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                            default:
                                              return Text('', style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 14));
                                          }
                                        },
                                        reservedSize: 30,
                                      ),
                                    ),
                                  ),
                                  borderData: FlBorderData(
                                    show: true,
                                    border: Border(
                                      bottom: BorderSide(color: Colors.black, width: 4),
                                      left: BorderSide(color: Colors.black, width: 4),
                                    ),
                                  ),
                                  minX: 0,
                                  maxX: 6,
                                  minY: 0,
                                  maxY: 1.5,
                                  lineBarsData: [
                                    LineChartBarData(
                                      spots: soundLevels
                                          .asMap()
                                          .entries
                                          .map((entry) => FlSpot(entry.key * 1.0, entry.value))  // 0.5초 간격으로 설정
                                          .toList(),
                                      isCurved: false,
                                      color: yellowColor,
                                      barWidth: 6,
                                      isStrokeCapRound: true,
                                      dotData: FlDotData(show: false),
                                    ),
                                  ],
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                    Container(
                      width: 800.0,
                      height: 150.0,
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            '완성한 풍선의 개수',
                            style: ts2,
                          ),
                          SizedBox(height: 10),
                          Row(
                            children: [
                              Image.asset(
                                'assets/images/balloon.png',
                                scale: 45.0,
                              ),
                              Text(
                                ' X 4',
                                style: ts2.copyWith(fontWeight: FontWeight.w700),
                              )
                            ],
                          )
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
