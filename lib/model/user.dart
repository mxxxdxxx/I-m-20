// 데이터 구조를 정의, JSON 변환 담당
class User {
  final int? userId;
  final String? userName;
  final String? userLoginId;
  final String? userPassword;
  final int? userLoginType;
  final int? userSnsKey;
  final int? userPhone;
  final int? userParentPassword;
  final int userStamp;
  final String? userProfilePhoto;
  final int? userLevel;

  User(
      {this.userId,
      this.userName,
      this.userLoginId,
      this.userPassword,
      this.userLoginType,
      this.userSnsKey,
      this.userPhone,
      this.userParentPassword,
      required this.userStamp,
      this.userProfilePhoto,
      this.userLevel});

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      userId: json['userId'],
      userName: json['userName'],
      userLoginId: json['userLoginId'],
      userPassword: json['userPassword'],
      userLoginType: json['userLoginType'],
      userSnsKey: json['userSnsKey'],
      userPhone: json['userPhone'],
      userParentPassword: json['userParentPassword'],
      userStamp: json['userStamp'],
      userProfilePhoto: json['userProfilePhoto'],
      userLevel: json['userLevel'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'userId': userId,
      'userName': userName,
      'userLoginId': userLoginId,
      'userPassword': userPassword,
      'userLoginType': userLoginType,
      'userSnsKey': userSnsKey,
      'userPhone': userPhone,
      'userParentPassword': userParentPassword,
      'userStamp': userStamp,
      'userProfilePhoto': userProfilePhoto,
      'userLevel': userLevel
    };
  }
}
