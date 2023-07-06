package com.cg.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bank.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    
}