package com.cts.sbdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbdd.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
