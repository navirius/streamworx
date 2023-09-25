package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.Api2UserPostDataRequest;
import com.assignment.streamworx.api1.model.Api2UserPostDataResponse;
import com.assignment.streamworx.api1.model.ListApi1UserPostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "api2-service", url = "${api2base-url}", fallbackFactory = Api2FeignCallbackFactory.class)
public interface Api2FeignService {
    @PostMapping(value = "/userpost/save", consumes = {MediaType.APPLICATION_XML_VALUE, "text/xml"})
    ResponseEntity<String> saveUserPost(@RequestBody Api2UserPostDataRequest request);

    @PostMapping("/userpost/delete")
    void deleteUserPost(@RequestBody Api2UserPostDataRequest request);

    @PostMapping("/userpost/update")
    void updateUserPost(@RequestBody Api2UserPostDataRequest request);

    @GetMapping(value = "/userpost/getpost", consumes = {MediaType.APPLICATION_XML_VALUE, "text/xml"})
    ResponseEntity<ListApi1UserPostResponse> getUserPost(@RequestParam("postId")Integer postId);

    @GetMapping(value = "/userpost/allpostuser", consumes = {MediaType.APPLICATION_XML_VALUE, "text/xml"})
    ResponseEntity<ListApi1UserPostResponse> getAllUserDataPost(@RequestParam("userId") Integer userId);

    @GetMapping(value = "/userpost/allpost", consumes = {MediaType.APPLICATION_XML_VALUE, "text/xml"})
    ResponseEntity<ListApi1UserPostResponse> getAllDataPost();
}
