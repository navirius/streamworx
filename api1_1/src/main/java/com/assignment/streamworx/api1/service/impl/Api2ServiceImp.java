package com.assignment.streamworx.api1.service.impl;

import com.assignment.streamworx.api1.feign.Api2FeignService;
import com.assignment.streamworx.api1.model.Api2UserDataRequest;
import com.assignment.streamworx.api1.model.Api2UserDataResponse;
import com.assignment.streamworx.api1.model.Api2UserPostDataResponse;
import com.assignment.streamworx.api1.service.Api2Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class Api2ServiceImp implements Api2Service {
    @Autowired
    Api2FeignService api2FeignService;
    @Override
    public Api2UserDataResponse getUserData(Integer userId) {
        try {
            Api2UserDataRequest request = new Api2UserDataRequest();
            request.setId(userId);
            ResponseEntity<String> response = api2FeignService.getUserData(request);
            if (response != null && response.getBody() != null) {
                String body = response.getBody();
                XmlMapper mapper = new XmlMapper();
                Api2UserDataResponse dataResponse = mapper.readValue(body, Api2UserDataResponse.class);
                return dataResponse;
            }
        }
        catch (Exception ex){
            log.error("ERROR", ex);
        }
        return null;
    }

    @Override
    public List<Api2UserPostDataResponse> getAllUserPost(Integer userId) {
        try{
            ResponseEntity<String> response = api2FeignService.getAllUserDataPost(userId);
            if(response!=null && response.getBody()!=null){
                String body = response.getBody();
                XmlMapper mapper = new XmlMapper();
                List<Api2UserPostDataResponse> dataResponse = mapper.readValue(body, new TypeReference<List<Api2UserPostDataResponse>>(){});

                return dataResponse;
            }
        }
        catch (Exception ex){
            log.error("ERROR", ex);
        }
        return null;
    }
}
