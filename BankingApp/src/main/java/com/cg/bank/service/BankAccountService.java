package com.cg.bank.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bank.entity.BankAccount;
import com.cg.bank.repository.BankAccountRepository;

@org.springframework.stereotype.Service
public class BankAccountService {
	
	@Autowired
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount getBankAccount(Long id) {
        // Implement logic to retrieve a bank account by ID
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Bank account not found"));
    }

    public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
        // Implement logic to update a bank account
        BankAccount existingBankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Bank account not found"));

        existingBankAccount.setAccountNumber(bankAccount.getAccountNumber());
        existingBankAccount.setBalance(bankAccount.getBalance());
        // Update other fields as needed

        return bankAccountRepository.save(existingBankAccount);
    }

    public void deleteBankAccount(Long id) {
        // Implement logic to delete a bank account
        bankAccountRepository.deleteById(id);
    }
}
