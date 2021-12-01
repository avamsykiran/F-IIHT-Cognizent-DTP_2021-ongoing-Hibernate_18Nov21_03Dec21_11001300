package com.cts.sbdd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "emps")
public class Employee implements Comparable<Employee>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;
	@Column(name = "emp_name", nullable = false)
	private String name;
	@Column(name = "basic_pay", nullable = false)
	private Double basic;

	@Embedded
	private Address currentAddress;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department dept;

	@OneToOne(mappedBy = "holder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BankAccount salAccount;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String name, Double basic, Address currentAddress,Department dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.basic = basic;
		this.currentAddress = currentAddress;
		this.dept=dept;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basic=" + basic + ", currentAddress=" + currentAddress
				+ "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId!=null?this.empId.compareTo(o.empId):-1;
	}

}