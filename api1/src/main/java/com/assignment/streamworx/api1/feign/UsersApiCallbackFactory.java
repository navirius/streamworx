package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.RedisUserModel;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.ArrayList;
import java.util.List;

public class UsersApiCallbackFactory implements FallbackFactory<UsersApiFeignService> {
    @Override
    public UsersApiFeignService create(Throwable cause) {
        return new UsersApiFeignService() {
            @Override
            public List<RedisUserModel> getAllData() {
                return new ArrayList<>();
            }
        };
    }
}
