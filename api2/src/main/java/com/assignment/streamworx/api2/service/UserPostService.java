package com.assignment.streamworx.api2.service;

import com.assignment.streamworx.api2.model.UserPostRequest;
import com.assignment.streamworx.api2.model.UserPostResponse;

import java.util.List;

public interface UserPostService {
    UserPostResponse saveUserPost(UserPostRequest request);
    void deleteUserPost(UserPostRequest request);
    void updateUserPost(UserPostRequest request);
    UserPostResponse getUserPost(Integer postId);
    List<UserPostResponse> getAllUserPost(Integer userId);
    List<UserPostResponse> getAllPost();
}
