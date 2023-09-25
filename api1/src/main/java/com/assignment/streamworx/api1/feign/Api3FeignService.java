package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.Api3DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="api3-service", url = "https://jsonplaceholder.typicode.com", fallbackFactory = Api3FeignCallbackFactory.class)
public interface Api3FeignService {

    @GetMapping("/todos")
    List<Api3DataResponse> getAllApi3Data();
}
