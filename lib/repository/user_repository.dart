// lib/repositories/user_repository.dart
import 'package:http/http.dart' as http;
import 'dart:convert';
import '../model/user.dart';

class UserRepository {
  final String baseUrl;

  UserRepository({required this.baseUrl});

  Future<User> login(String username, String password) async {
    final response = await http.post(
      Uri.parse('http://10.0.2.2:8080/users/login'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, String>{
        'loginId': username,
        'password': password,
      }),
    );

    if (response.statusCode == 200) {
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to login: ${response.statusCode}');
    }
  }
}
