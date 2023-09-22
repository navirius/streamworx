package com.assignment.streamworx.api1.service.impl;

import com.assignment.streamworx.api1.entity.UserEntity;
import com.assignment.streamworx.api1.feign.Api3FeignService;
import com.assignment.streamworx.api1.model.Api1DataResponse;
import com.assignment.streamworx.api1.model.Api2UserDataResponse;
import com.assignment.streamworx.api1.model.Api2UserPostDataResponse;
import com.assignment.streamworx.api1.model.Api3DataResponse;
import com.assignment.streamworx.api1.repository.UserRepository;
import com.assignment.streamworx.api1.service.Api1Service;
import com.assignment.streamworx.api1.service.Api2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class Api1ServiceImpl implements Api1Service {
    @Autowired
    Api2Service api2Service;
    @Autowired
    Api3FeignService api3FeignService;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Api1DataResponse> getData(){
        List<UserEntity> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);

        List<Api3DataResponse> api3Response = api3FeignService.getAllApi3Data();
        List<Api1DataResponse> result = new ArrayList<>();
        if(api3Response!=null ){
            List<Api3DataResponse> api3DataResponses = api3Response;

            for(UserEntity userEntity:allUsers){
                Api1DataResponse api1DataResponse = new Api1DataResponse();
                BeanUtils.copyProperties(userEntity, api1DataResponse);

                List<Api2UserPostDataResponse> allDataResponseUser = api2Service.getAllUserPost(userEntity.getId());
                api1DataResponse.setPosts(allDataResponseUser);

                List<Api3DataResponse> allTodosUser = api3DataResponses.stream().filter(api3DataResponse -> api3DataResponse.getUserId().equals(userEntity.getId())).collect(Collectors.toList());
                api1DataResponse.setTodos(allTodosUser);

                result.add(api1DataResponse);
            }

            return result;
        }

        return new ArrayList<>();
    }
}
