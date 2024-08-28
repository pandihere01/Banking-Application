package net.firstproject.banking_app.service;

import net.firstproject.banking_app.dto.AccountDto;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id );

    AccountDto deposit(Long id , double amount );

    AccountDto withdrawn(Long id , double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

}
