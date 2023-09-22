package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.Api2UserDataRequest;
import com.assignment.streamworx.api1.model.Api2UserPostDataRequest;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Api2FeignCallbackFactory implements FallbackFactory<Api2FeignService> {
    @Override
    public Api2FeignService create(Throwable cause) {
        return new Api2FeignService() {
            @Override
            public ResponseEntity<String> saveUserPost(Api2UserPostDataRequest request) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
            }

            @Override
            public void deleteUserPost(Api2UserPostDataRequest request) {

            }

            @Override
            public void updateUserPost(Api2UserPostDataRequest request) {

            }

            @Override
            public ResponseEntity<String> getUserPost(Integer postId) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
            }

            @Override
            public void deleteUserData(Api2UserDataRequest request) {

            }

            @Override
            public void updateUserData(Api2UserDataRequest request) {

            }

            @Override
            public ResponseEntity<String> saveUserData(Api2UserDataRequest request) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
            }

            @Override
            public ResponseEntity<String> getUserData(Api2UserDataRequest request) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
            }

            @Override
            public ResponseEntity<String> getAllUserDataPost(Integer userId) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        };
    }
}
