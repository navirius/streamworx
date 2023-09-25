package com.assignment.streamworx.api2.service.impl;

import com.assignment.streamworx.api2.entity.PostEntity;
import com.assignment.streamworx.api2.model.UserPostRequest;
import com.assignment.streamworx.api2.model.UserPostResponse;
import com.assignment.streamworx.api2.repository.PostRepository;
import com.assignment.streamworx.api2.service.UserPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserPostServiceImpl implements UserPostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public UserPostResponse saveUserPost(UserPostRequest request) {
        PostEntity newPost = new PostEntity();
        BeanUtils.copyProperties(request, newPost);
        PostEntity dataSaved = postRepository.save(newPost);
        UserPostResponse result = new UserPostResponse();
        BeanUtils.copyProperties(dataSaved, result);
        return result;
    }

    @Override
    public void deleteUserPost(UserPostRequest request) {
        if(request.getId()==null)
            return;
        Optional<PostEntity> dbData = postRepository.findById(request.getId());
        if(dbData.isPresent())
            postRepository.delete(dbData.get());
    }

    @Override
    public void updateUserPost(UserPostRequest request) {
        Optional<PostEntity> dbData = postRepository.findById(request.getId());
        if(dbData.isPresent()){
            PostEntity postEntity = dbData.get();
            BeanUtils.copyProperties(request, postEntity);
            postRepository.saveAndFlush(postEntity);
        }
    }

    @Override
    public UserPostResponse getUserPost(Integer postId) {
        if(postId==null)
            return null;
        Optional<PostEntity> dbData = postRepository.findById(postId);
        if(dbData.isPresent()){
            PostEntity postEntity = dbData.get();
            UserPostResponse result=new UserPostResponse();
            BeanUtils.copyProperties(postEntity, result);
            return result;
        }
        return null;
    }

    @Override
    public List<UserPostResponse> getAllUserPost(Integer userId) {
        if(userId==null)
            return null;

        List<PostEntity> allPost = postRepository.findAllByUserid(userId);
        List<UserPostResponse> allPostResponse = new ArrayList<>();
        for(PostEntity post:allPost){
            UserPostResponse response = new UserPostResponse();
            BeanUtils.copyProperties(post, response);

            allPostResponse.add(response);
        }

        return allPostResponse;
    }

    @Override
    public List<UserPostResponse> getAllPost() {
        List<PostEntity> allPost = postRepository.findAll();
        List<UserPostResponse> allPostResponse = new ArrayList<>();
        for(PostEntity post:allPost){
            UserPostResponse response = new UserPostResponse();
            BeanUtils.copyProperties(post, response);

            allPostResponse.add(response);
        }

        return allPostResponse;
    }
}
