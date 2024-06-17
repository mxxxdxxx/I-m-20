import 'package:flutter/material.dart';
import 'package:speakiz_im/model/user.dart';
import 'package:speakiz_im/repository/user_repository.dart';

class UserProvider with ChangeNotifier {
  User? _user;
  final UserRepository _userRepository = UserRepository();

  User? get user => _user;

  void setUser(User user) {
    _user = user;
    notifyListeners();
  }

  String get userLevelText {
    if (_user == null) return '';
    return _userRepository.getUserLevelText(_user!.userLevel ?? 0);
  }

}
