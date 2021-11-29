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

public class App {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();

		TypedQuery<Department> qry = em.createQuery("SELECT d FROM Department d",Department.class);
		qry.getResultStream().forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		Query qry2 = em.createQuery("SELECT e.name,e.dept.name FROM Employee e");
		((Stream<Object[]>)qry2.getResultStream()).
		forEach(arr -> System.out.println(arr[0]+"\t"+arr[1]));
		
		em.close();
	}

}
