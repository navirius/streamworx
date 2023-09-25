package com.assignment.streamworx.api2.feign;

import com.assignment.streamworx.api2.entity.PostEntity;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.ArrayList;
import java.util.List;

public class PostFeignClientFallback implements FallbackFactory<PostFeignClientService> {
    @Override
    public PostFeignClientService create(Throwable cause) {
        return new PostFeignClientService() {
            @Override
            public List<PostEntity> getListPosts() {
                return new ArrayList<>();
            }
        };
    }
}
