package com.cts.jhd.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "M")
//@Table(name="mgrs_2")
@Table(name="mgrs_3")
public class Manager extends Employee{

	private Double allowence;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(Long empId, String ename, Double salary,Double allowence) {
		super(empId, ename, salary);
		this.allowence=allowence;
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}

	@Override
	public String toString() {
		return "Manager [allowence=" + allowence + ", toString()=" + super.toString() + "]";
	}
	
}
