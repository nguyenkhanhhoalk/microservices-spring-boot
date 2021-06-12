package com.hoank.user.service.impl;

import com.hoank.user.VO.DepartmentVO;
import com.hoank.user.VO.ResponseTemplateVO;
import com.hoank.user.entity.UserEntity;
import com.hoank.user.repository.UserRepository;
import com.hoank.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        log.info("Inside saveUser of UserServiceImpl");
        return userRepository.save(userEntity);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserServiceImpl");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        UserEntity user = userRepository.findByUserId(1L);
        DepartmentVO departmentVO = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                , DepartmentVO.class);

        vo.setUser(user);
        vo.setDepartment(departmentVO);

        return vo;
    }
}
