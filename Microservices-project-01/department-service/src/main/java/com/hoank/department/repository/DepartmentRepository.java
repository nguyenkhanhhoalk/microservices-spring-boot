package com.hoank.department.repository;

import com.hoank.department.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    DepartmentEntity findByDepartmentId(Long departmentId);
}
