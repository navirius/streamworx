package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.Api2UserPostDataRequest;
import com.assignment.streamworx.api1.model.ListApi1UserPostResponse;
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
            public ResponseEntity<ListApi1UserPostResponse> getUserPost(Integer postId) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }


            @Override
            public ResponseEntity<ListApi1UserPostResponse> getAllUserDataPost(Integer userId) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

            @Override
            public ResponseEntity<ListApi1UserPostResponse> getAllDataPost() {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        };
    }
}
