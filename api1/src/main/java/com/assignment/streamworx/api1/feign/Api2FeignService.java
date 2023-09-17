package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.Api2UserDataRequest;
import com.assignment.streamworx.api1.model.Api2UserDataResponse;
import com.assignment.streamworx.api1.model.Api2UserPostDataRequest;
import com.assignment.streamworx.api1.model.Api2UserPostDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "api2-service", url = "${api2base-url}", fallbackFactory = Api2FeignCallbackFactory.class)
public interface Api2FeignService {
    @PostMapping("/userpost/save")
    ResponseEntity<String> saveUserPost(@RequestBody Api2UserPostDataRequest request);

    @PostMapping("/userpost/delete")
    void deleteUserPost(@RequestBody Api2UserPostDataRequest request);

    @PostMapping("/userpost/update")
    void updateUserPost(@RequestBody Api2UserPostDataRequest request);

    @GetMapping("/userpost/getpost")
    ResponseEntity<String> getUserPost(@RequestParam("postId")Integer postId);

    @PostMapping("/user/deleteUser")
    void deleteUserData(@RequestBody Api2UserDataRequest request);

    @PostMapping("/user/updateUser")
    void updateUserData(@RequestBody Api2UserDataRequest request);

    @PostMapping("/user/saveUser")
    ResponseEntity<String> saveUserData(@RequestBody Api2UserDataRequest request);

    @PostMapping("/user/getUser")
    ResponseEntity<String> getUserData(@RequestBody Api2UserDataRequest request);

    @GetMapping("/userpost/allpostuser")
    ResponseEntity<String> getAllUserDataPost(Integer userId);
}
