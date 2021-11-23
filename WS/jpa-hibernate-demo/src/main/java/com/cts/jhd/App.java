package com.cts.jhd;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.cts.jhd.entity.Department;

public class App {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.
				createEntityManagerFactory("mysqlPU").
				createEntityManager();
		
		Scanner kbin=new Scanner(System.in);
		
		String concern="YES";
		
		em.getTransaction().begin();
		
		while("YES".equalsIgnoreCase(concern)) {
			System.out.print("Dept Name? ");
			String dname=kbin.next();
			Department d = new Department(dname);
			em.persist(d);
			System.out.print("Add more(YES/NO)? ");
			concern =kbin.next();
		}
		
		em.getTransaction().commit();
		
		em.close();
	}

}
