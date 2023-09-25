package com.assignment.streamworx.api1.service;

import com.assignment.streamworx.api1.feign.Api2FeignService;
import com.assignment.streamworx.api1.model.Api2UserPostDataResponse;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Api2Service {
    List<Api2UserPostDataResponse> getAllUserPost(Integer userId);
}
