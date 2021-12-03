package com.cts.sbdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.sbdd.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	boolean existsByName(String name);

	List<Employee> findAllByName(String name);

	@Query("SELECT e FROM Employee e WHERE e.basic BETWEEN :lb AND :ub")
	List<Employee> getAllEmployeesInRangeOfBasic(double lb, double ub);
}
