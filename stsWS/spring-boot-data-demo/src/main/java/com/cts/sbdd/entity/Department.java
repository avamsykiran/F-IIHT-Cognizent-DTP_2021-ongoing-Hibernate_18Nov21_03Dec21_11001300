package com.cts.sbdd.entity;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "depts")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Long deptId;

	@Column(name = "dept_name", nullable = false, unique = true, length = 50)
	private String name;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Employee> employees;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String name) {
		this.name = name;
		this.employees = new TreeSet<Employee>();
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}

}