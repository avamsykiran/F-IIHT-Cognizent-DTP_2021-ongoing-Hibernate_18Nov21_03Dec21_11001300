package com.cts.sbdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.sbdd.entity.Address;
import com.cts.sbdd.entity.BankAccount;
import com.cts.sbdd.entity.Department;
import com.cts.sbdd.entity.Employee;
import com.cts.sbdd.repo.BankAccountRepo;
import com.cts.sbdd.repo.DepartmentRepo;
import com.cts.sbdd.repo.EmployeeRepo;

@SpringBootApplication
public class SpringBootDataDemoApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepo deptRepo;

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private BankAccountRepo bankRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department d = new Department("Accounts Dept");

		Employee e1 = new Employee(null, "Vinodh", 56800.0, 
				new Address("4-16/1", "Vizag", "Andhra"), d);
		e1.setSalAccount(new BankAccount("567007", "SBI009", e1));

		Employee e2 = new Employee(null, "Tarun", 96800.0, 
				new Address("4-20/20", "Tirupathi", "Andhra"), d);
		e2.setSalAccount(new BankAccount("567009", "SBI009", e2));

		d.getEmployees().add(e1);
		d.getEmployees().add(e2);

		deptRepo.saveAndFlush(d);
	}
}
