class User {
  final String? loginId;
  final String? userId;
  final String? userName;
  final int? level;

  User({this.loginId, this.userId, this.userName, this.level});

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      loginId: json['loginId'],
      userId: json['userId'],
      userName: json['userName'],
      level: json['level'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'loginId': loginId,
      'userId': userId,
      'userName': userName,
      'level': level,
    };
  }
}
