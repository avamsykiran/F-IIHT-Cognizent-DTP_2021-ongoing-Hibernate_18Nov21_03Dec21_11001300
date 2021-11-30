package com.cts.jhd;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jhd.entity.Address;
import com.cts.jhd.entity.BankAccount;
import com.cts.jhd.entity.Department;
import com.cts.jhd.entity.Employee;
import com.cts.jhd.model.DeptEmpCount;

public class App {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();

		TypedQuery<Department> qry = em.createNamedQuery("ALL_DEPTS",Department.class);
		qry.getResultStream().forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		TypedQuery<Employee> qry2 = em.createNamedQuery("ALL_EMPS",Employee.class);
		qry2.getResultStream().forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		Query qry3 = em.createNamedQuery("ENAME_DNAME");
		((Stream<Object[]>)qry3.getResultStream()).
		forEach(arr -> System.out.println(arr[0]+"\t"+arr[1]));
		
		System.out.println("-------------------------------------------");
		
		TypedQuery<Employee> qry4 = em.createNamedQuery("ALL_EMPS_OF_RANGE",Employee.class);
		qry4.setParameter("lb", 50000.0);
		qry4.setParameter("ub", 150000.0);
		qry4.getResultStream().forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		Query qry5 = em.createNamedQuery("DEPT_EMP_COUNT");
		((Stream<Object[]>)qry5.getResultStream()).
		forEach(arr -> System.out.println(arr[0]+"\t"+arr[1]));

		System.out.println("-------------------------------------------");
		
		TypedQuery<DeptEmpCount> qry6 = em.createNamedQuery("DEPT_EMP_COUNT2",DeptEmpCount.class);
		qry6.getResultStream().forEach(System.out::println);
		
		
		em.close();
	}

}
