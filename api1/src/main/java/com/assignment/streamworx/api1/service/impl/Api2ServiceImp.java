package com.assignment.streamworx.api1.service.impl;

import com.assignment.streamworx.api1.feign.Api2FeignService;
import com.assignment.streamworx.api1.model.Api2UserPostDataResponse;
import com.assignment.streamworx.api1.model.ListApi1UserPostResponse;
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
    public List<Api2UserPostDataResponse> getAllUserPost(Integer userId) {
        try{
            ResponseEntity<ListApi1UserPostResponse> response = api2FeignService.getAllUserDataPost(userId);
            if(response!=null && response.getBody()!=null){
                ListApi1UserPostResponse body = response.getBody();
                XmlMapper mapper = new XmlMapper();
                List<Api2UserPostDataResponse> dataResponse = body.getRow();

                return dataResponse;
            }
        }
        catch (Exception ex){
            log.error("ERROR", ex);
        }
        return null;
    }
}
