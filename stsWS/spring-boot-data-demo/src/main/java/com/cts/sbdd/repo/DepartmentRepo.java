package com.cts.sbdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbdd.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
