package com.hoank.config.multipledb.repository;

import com.hoank.config.multipledb.admissions.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {

}
