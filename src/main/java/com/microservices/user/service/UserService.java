package com.microservices.user.service;

import com.microservices.user.VO.Department;
import com.microservices.user.VO.RestTemplateVO;
import com.microservices.user.entity.User;
import com.microservices.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return  userRepository.save(user);
    }

    public RestTemplateVO getUserwithDepartment(Long userId)
    {
        log.info("Inside getUserwithDepartment of UserService");
        RestTemplateVO vo = new RestTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/" +
                user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
