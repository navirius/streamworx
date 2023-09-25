package com.assignment.streamworx.api2.feign;

import com.assignment.streamworx.api2.entity.PostEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post-feign", url = "https://jsonplaceholder.typicode.com/", fallbackFactory = PostFeignClientFallback.class)
public interface PostFeignClientService {
    @GetMapping(value = "posts")
    List<PostEntity> getListPosts();
}
