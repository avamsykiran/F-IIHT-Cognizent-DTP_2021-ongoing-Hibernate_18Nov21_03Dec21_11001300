package com.cts.sbdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbdd.entity.BankAccount;

public interface BankAccountRepo extends JpaRepository<BankAccount, String>{

}
