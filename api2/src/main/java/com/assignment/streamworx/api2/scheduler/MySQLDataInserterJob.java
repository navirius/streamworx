package com.assignment.streamworx.api2.scheduler;

import com.assignment.streamworx.api2.entity.PostEntity;
import com.assignment.streamworx.api2.feign.PostFeignClientService;
import com.assignment.streamworx.api2.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class MySQLDataInserterJob {
    @Autowired
    PostFeignClientService postFeignClientService;
    @Autowired
    PostRepository postRepository;
    @Scheduled(initialDelay = 2, timeUnit = TimeUnit.SECONDS, fixedDelay = 999999999)
    public void insertDataMySQL(){
        List<PostEntity> listData = postFeignClientService.getListPosts();
        for(PostEntity postEntity:listData){
            Optional<PostEntity> dbData = postRepository.findById(postEntity.getId());
            PostEntity dbItem;
            if(dbData.isPresent()){
                dbItem = dbData.get();
            }
            else{
                dbItem = new PostEntity();
            }
            BeanUtils.copyProperties(postEntity, dbItem);
            postRepository.save(dbItem);
        }
    }

}
