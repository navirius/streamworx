package com.assignment.streamworx.api2.service;

import com.assignment.streamworx.api2.model.UserDataModel;

public interface UserService {
    void deleteUserData(UserDataModel data);
    void updateUserData(UserDataModel data);
    UserDataModel saveUserData(UserDataModel data);
    UserDataModel getUserData(Integer userId);
}
