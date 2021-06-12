package com.hoank.user.service;

import com.hoank.user.VO.ResponseTemplateVO;
import com.hoank.user.entity.UserEntity;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    ResponseTemplateVO getUserWithDepartment(Long userId);
}
