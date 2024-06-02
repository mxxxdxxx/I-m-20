// 데이터 구조를 정의, JSON 변환 담당
class User {
  final String? userLoginId;
  final String? userPassword;
  final String? userId;
  final String? userName;
  final int? level;

  User({this.userLoginId, this.userPassword, this.userId, this.userName, this.level});

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      userLoginId: json['userLoginId'],
      userPassword: json['userPassword'],
      userId: json['userId'],
      userName: json['userName'],
      level: json['level'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'userLoginId': userLoginId,
      'userPassword': userPassword,
      'userId': userId,
      'userName': userName,
      'level': level,
    };
  }
}
