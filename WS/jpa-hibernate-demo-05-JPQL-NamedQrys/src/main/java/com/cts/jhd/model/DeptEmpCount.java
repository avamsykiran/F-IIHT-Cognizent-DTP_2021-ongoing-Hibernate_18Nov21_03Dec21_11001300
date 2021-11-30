package com.cts.jhd.model;

public class DeptEmpCount {

	private String deptName;
	private long empcount;
	
	public DeptEmpCount() {
		// TODO Auto-generated constructor stub
	}

	public DeptEmpCount(String deptName, long empcount) {
		super();
		this.deptName = deptName;
		this.empcount = empcount;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getEmpcount() {
		return empcount;
	}

	public void setEmpcount(long empcount) {
		this.empcount = empcount;
	}

	@Override
	public String toString() {
		return "DeptEmpCount [deptName=" + deptName + ", empcount=" + empcount + "]";
	}
	
	
}
