package com.cts.jhd;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.cts.jhd.entity.Address;
import com.cts.jhd.entity.BankAccount;
import com.cts.jhd.entity.Department;
import com.cts.jhd.entity.Employee;

public class App {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();

		Department d1 = new Department("JavaFSD");
		Department d2 = new Department("HR");

		Employee e1 = new Employee(null, "Vamsy", 45670.0, 
				new Address("4-17/1", "Vizag", "AP"), d1);
		e1.setSalAccount(new BankAccount("10000000000011", "SBI010023", e1));

		Employee e2 = new Employee(null, "Suseela", 145670.0, 
				new Address("5-17/1", "Vijayawada", "AP"), d2);
		e2.setSalAccount(new BankAccount("10000000000022", "SBI010023", e2));

		Employee e3 = new Employee(null, "Srinivas", 245670.0, 
				new Address("0-19/1", "Tirupathi", "AP"), d1);
		e3.setSalAccount(new BankAccount("10000000000033", "SBI010023", e3));

		d1.getEmployees().add(e1);
		d1.getEmployees().add(e3);
		
		d2.getEmployees().add(e2);
		
		em.getTransaction().begin();
		em.persist(d1);
		em.persist(d2);
		em.getTransaction().commit();

		em.close();
	}

}
