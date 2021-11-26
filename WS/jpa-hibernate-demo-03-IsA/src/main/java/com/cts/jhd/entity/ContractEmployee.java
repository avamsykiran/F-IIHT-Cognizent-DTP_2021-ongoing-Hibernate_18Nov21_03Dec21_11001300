package com.cts.jhd.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "C")
//@Table(name="cemps_2")
@Table(name="cemps_3")
public class ContractEmployee extends Employee{

	private Long duration;
	
	public ContractEmployee() {
		// TODO Auto-generated constructor stub
	}

	public ContractEmployee(Long empId, String ename, Double salary,Long duration) {
		super(empId, ename, salary);
		this.duration=duration;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "ContractEmployee [duration=" + duration + ", toString()=" + super.toString() + "]";
	}
	
}
