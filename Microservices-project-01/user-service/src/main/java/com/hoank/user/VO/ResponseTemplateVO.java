package com.hoank.user.VO;

import com.hoank.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private UserEntity user;
    private DepartmentVO department;
}
