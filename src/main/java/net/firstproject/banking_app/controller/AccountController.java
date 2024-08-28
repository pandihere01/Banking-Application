package net.firstproject.banking_app.controller;

import net.firstproject.banking_app.dto.AccountDto;
import net.firstproject.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API

    @PostMapping


    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto) , HttpStatus.CREATED);
    }

    //Get Account Rest Api

    @GetMapping("/{id}")

    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){

        AccountDto accountDto = accountService.getAccountById(id);

        return ResponseEntity.ok(accountDto);
    }
    //Deposit REST API

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id ,@RequestBody Map<String ,Double> request){

        double amount = request.get("amount");

        AccountDto accountDto =  accountService.deposit(id , amount);

        return  ResponseEntity.ok(accountDto);
    }

    //Withdrawn REST API
    @PutMapping("/{id}/withdrawn")
    public  ResponseEntity<AccountDto> withdrawn(@PathVariable Long id , @RequestBody Map<String ,Double > request){

        double amount = request.get("amount");

        AccountDto accountDto = accountService.withdrawn(id , amount);

        return ResponseEntity.ok(accountDto);

    }

    // Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){

        List<AccountDto> accounts =  accountService.getAllAccounts();

        return ResponseEntity.ok(accounts);
    }

    //Delete Account REST API
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteAccount(@PathVariable Long id){

        accountService.deleteAccount(id);

        return ResponseEntity.ok("Acccount deleted successfully...");
    }
}
