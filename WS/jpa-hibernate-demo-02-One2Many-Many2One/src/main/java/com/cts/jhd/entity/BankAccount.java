package com.cts.jhd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank_accounts")
public class BankAccount {

	@Id
	@Column(name="acc_num",length = 16)
	private String accNum;
	@Column(name="ifsc",length = 10,nullable = false)
	private String ifscCode;
	
	@OneToOne
	@JoinColumn(name="emp_id")
	private Employee holder;

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public BankAccount(String accNum, String ifscCode, Employee holder) {
		super();
		this.accNum = accNum;
		this.ifscCode = ifscCode;
		this.holder = holder;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Employee getHolder() {
		return holder;
	}

	public void setHolder(Employee holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", ifscCode=" + ifscCode + ", holder=" + holder.getName() + "]";
	}
}
