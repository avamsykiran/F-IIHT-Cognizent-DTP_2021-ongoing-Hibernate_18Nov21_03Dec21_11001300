package com.cts.jhd;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.cts.jhd.entity.ContractEmployee;
import com.cts.jhd.entity.Employee;
import com.cts.jhd.entity.Manager;

public class App {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();

		em.getTransaction().begin();
		em.persist(new Employee(1L, "Vamsy", 456789.0));
		em.persist(new ContractEmployee(2L, "Srinivas", 56789.0,10L));
		em.persist(new Manager(3L, "Indhikaa", 1456789.0,56788.0));
		em.getTransaction().commit();
		em.close();
	}

}
