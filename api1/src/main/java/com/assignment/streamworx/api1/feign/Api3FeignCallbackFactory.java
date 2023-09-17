package com.assignment.streamworx.api1.feign;

import com.assignment.streamworx.api1.model.Api3DataResponse;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Api3FeignCallbackFactory implements FallbackFactory<Api3FeignService> {
    @Override
    public Api3FeignService create(Throwable cause) {
        return new Api3FeignService() {
            @Override
            public ResponseEntity<Api3DataResponse> getAllApi3Data() {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        };
    }
}
