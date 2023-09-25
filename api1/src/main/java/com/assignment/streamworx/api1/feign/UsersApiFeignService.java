package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.RedisUserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="redis-service", url = "https://jsonplaceholder.typicode.com/", fallbackFactory = UsersApiCallbackFactory.class)
public interface UsersApiFeignService {
    @GetMapping("users")
    List<RedisUserModel> getAllData();
}
