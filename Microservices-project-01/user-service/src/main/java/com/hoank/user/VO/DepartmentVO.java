package com.hoank.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVO {

    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}