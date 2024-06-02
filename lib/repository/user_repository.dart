// 데이터 소스와의 통신 담당 서버와의 네트워크 요청을 처리하고, 서버로부터 데이터를 받아와서 모델 객체로 변환
// 변환 자체는 모델 담당이지만 실제로 변환을 호출하는 코드는 리포지토리
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:speakiz/model/user.dart';

class UserRepository {
  final String baseUrl;

  UserRepository({required this.baseUrl});

  Future<User> login(String userLoginId, String userPassword) async {
    final response = await http.post(
      Uri.parse('$baseUrl/users/login'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      // Dart 객체를 JSON 문자열로 변환
      body: jsonEncode(<String, String>{
        'userLoginId': userLoginId,
        'userPassword': userPassword,
      }),
    );

    if (response.statusCode == 200) {
      // 서버 응답을 JSON에서 User 객체로 변환
      // JSON 문자열을 Dart 객체로 변환
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to login: ${response.statusCode}');
    }
  }
}
