package com.cts.jhd.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*
@Table(name="emps_1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "etype",length = 1,discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "E")
 */
/*@Table(name="emps_2")
@Inheritance(strategy = InheritanceType.JOINED)*/
@Table(name="emps_3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String ename;
	private Double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String ename, Double salary) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.salary = salary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
	
}
