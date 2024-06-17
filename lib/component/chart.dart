import 'package:flutter/material.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:speakiz_im/const/color.dart';

class LineChartSample extends StatelessWidget {
  final List<double> data = [10, 35, 55, 65, 70, 85, 95];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              width: 500,
              height: 200,
              decoration: BoxDecoration(
                color: ywColor,
                borderRadius: BorderRadius.circular(15),
              ),
              child: Padding(
                padding: const EdgeInsets.all(20.0),
                child: LineChart(
                  LineChartData(
                    backgroundColor: Colors.transparent,
                    lineBarsData: [
                      LineChartBarData(
                        spots: data.asMap().entries.map((entry) {
                          return FlSpot(entry.key.toDouble(), entry.value);
                        }).toList(),
                        isCurved: false,
                        color: yellowColor,
                        barWidth: 4,
                        dotData: FlDotData(
                          show: true,
                          getDotPainter: (spot, percent, barData, index) =>
                              FlDotCirclePainter(
                                radius: 6,
                                color: yellowColor,
                                strokeWidth: 0,
                              ),
                        ),
                        belowBarData: BarAreaData(show: false),
                      ),
                    ],
                    minY: 0,
                    maxY: 100,
                    titlesData: FlTitlesData(
                      bottomTitles: AxisTitles(
                        sideTitles: SideTitles(
                          showTitles: true,
                          interval: 1,
                          getTitlesWidget: (value, meta) {
                            const style = TextStyle(
                                color: navyColor,
                                fontSize: 12,
                                fontWeight: FontWeight.w700);
                            switch (value.toInt()) {
                              case 0:
                                return Text('1일', style: style);
                              case 1:
                                return Text('2일', style: style);
                              case 2:
                                return Text('3일', style: style);
                              case 3:
                                return Text('4일', style: style);
                              case 4:
                                return Text('5일', style: style);
                              case 5:
                                return Text('6일', style: style);
                              case 6:
                                return Text('7일', style: style);
                              default:
                                return Text('', style: style);
                            }
                          },
                        ),
                      ),
                      leftTitles: AxisTitles(
                        sideTitles: SideTitles(
                          showTitles: true,
                          getTitlesWidget: (value, meta) {
                            const style = TextStyle(
                              color: navyColor,
                              fontSize: 12,
                              fontWeight: FontWeight.w700,
                            );
                            switch (value.toInt()) {
                              case 0:
                                return Text('0', style: style);
                              case 20:
                                return Text('20', style: style);
                              case 40:
                                return Text('40', style: style);
                              case 60:
                                return Text('60', style: style);
                              case 80:
                                return Text('80', style: style);
                              case 100:
                                return Text('100', style: style);
                              default:
                                return Text('', style: style);
                            }
                          },
                          interval: 20,
                        ),
                      ),
                      topTitles: AxisTitles(
                        sideTitles: SideTitles(showTitles: false),
                      ),
                      rightTitles: AxisTitles(
                        sideTitles: SideTitles(showTitles: false),
                      ),
                    ),
                    gridData: FlGridData(show: false),
                    borderData: FlBorderData(
                      show: true,
                      border: const Border(
                        bottom: BorderSide(color: navyColor, width: 5),
                        left: BorderSide(color: navyColor, width: 5),
                        right: BorderSide(color: Colors.transparent),
                        top: BorderSide(color: Colors.transparent),
                      ),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
