package com.cg.bank.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.entity.Loan;
import com.cg.bank.repository.LoanRepository;

@Service
public class LoanService {
	@Autowired
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan generateLoan(Loan loan) {
        // Implement loan generation logic
        // You can calculate interest, set repayment terms, etc.
        return loanRepository.save(loan);
    }

    public Loan getLoan(Long id) {
        // Implement logic to retrieve a loan by ID
        return loanRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Loan not found"));
    }

    public Loan updateLoan(Long id, Loan loan) {
        // Implement logic to update a loan
        Loan existingLoan = loanRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Loan not found"));

        existingLoan.setLoanNumber(loan.getLoanNumber());
        existingLoan.setAmount(loan.getAmount());
        // Update other fields as needed

        return loanRepository.save(existingLoan);
    }

    public void deleteLoan(Long id) {
        // Implement logic to delete a loan
        loanRepository.deleteById(id);
    }
}
