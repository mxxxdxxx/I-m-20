import 'package:http/http.dart' as http;
import 'dart:convert';
import '../model/user.dart';

class UserRepository {
  final String baseUrl;
  static final UserRepository _instance = UserRepository._internal('http://10.0.2.2:8080');
  UserRepository._internal(this.baseUrl);

  // 외부에서 인스턴스에 접근할 수 있는 방법
  factory UserRepository() {
    return _instance;
  }

  // 회원가입 요청
  Future<void> register(String userName, String userLoginId, String userPassword, int userPhone) async {
    final Map<String, dynamic> data = {
      'userName': userName,
      'userLoginId': userLoginId,
      'userPassword': userPassword,
      'userPhone': userPhone,
    };
    // 회원가입 엔드포인트?는 없길래 일단..
    final response = await http.post(
      Uri.parse('$baseUrl/users/register'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(data),
    );

    if (response.statusCode != 200) {
      throw Exception('Failed to register: ${response.statusCode}');
    }
  }

  // 로그인 요청
  Future<User> login(String userLoginId, String userPassword) async {
    final response = await http.post(
      Uri.parse('$baseUrl/users/login'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, String>{
        'userLoginId': userLoginId,
        'userPassword': userPassword,
      }),
    );

    if (response.statusCode == 200) {
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to login: ${response.statusCode}');
    }
  }

  Future<User> fetchUser(String userId) async {
    final response = await http.get(Uri.parse('$baseUrl/users/$userId'));

    if (response.statusCode == 200) {
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to fetch user: ${response.statusCode}');
    }
  }

  // 레벨 전송 함수임다 sendlevel에서 sendUserLevel로 이름 변경했어여
  Future<void> sendUserLevel(int userId, int userLevel) async {
    final Map<String, dynamic> data = {
      'userId': userId,
      'userLevel': userLevel,
    };

    final response = await http.post(
      Uri.parse('$baseUrl/users/level'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(data), // 요청 본문을 JSON 형식으로 인코딩
    );

    if (response.statusCode != 200) {
      throw Exception('Failed to send user level: ${response.statusCode}');
    }
  }
  // 이 코드는 서버에 레벨을 전송할때는 0,1로 하자나여 근데 레벨 결과 보여줄때나 마이페이지 등 다른 스크린에 띄울때는 텍스트로 띄워야해서 변환하는 코드에여
  String getUserLevelText(int userLevel) {
    switch (userLevel) {
      case 0:
        return "기초";
      case 1:
        return "보통";
      default:
        return "알 수 없음";
    }
  }

// 학부모용 비밀번호 전송
  Future<void> senduserParentPassword(int userId, String userParentPassword) async {
    final Map<String, dynamic> data = {
      'userId': userId,
      'userParentPassword': userParentPassword,
    };

    final response = await http.post(
      Uri.parse('$baseUrl/users/userParentPassword'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(data),
    );

    if (response.statusCode != 200) {
      throw Exception('Failed to send parent password: ${response.statusCode}');
    }
  }

// 학부모용 비밀번호 불러오기
  Future<String> fetchuserParentPassword(int userId) async {
    final response = await http.get(Uri.parse('$baseUrl/users/$userId/userParentPassword'));

    if (response.statusCode == 200) {
      final data = jsonDecode(response.body);
      return data['userParentPassword'];
    } else {
      throw Exception('Failed to fetch parent password: ${response.statusCode}');
    }
  }

  // 평균 지속 시간 불러오기
  // Future<List<double>> fetchAverageDurations(int userId) async {
  //   final response = await http.get(Uri.parse('$baseUrl/users/$userId/averageDurations'));
  //
  //   if (response.statusCode == 200) {
  //     final data = jsonDecode(response.body);
  //     return List<double>.from(data['averageDurations']);
  //   } else {
  //     throw Exception('Failed to fetch average durations: ${response.statusCode}');
  //   }
  // }
}



class TestValues {
  static int selectedValueTest1 = -1;
  static int selectedValueTest2 = -1;
  static int selectedValueTest3 = -1;
  static int selectedValueTest4 = -1;
  static int selectedValueTest5 = -1;

  static double getAverage() {
    return (selectedValueTest1 +
        selectedValueTest2 +
        selectedValueTest3 +
        selectedValueTest4 +
        selectedValueTest5) /
        5;
  }
}
