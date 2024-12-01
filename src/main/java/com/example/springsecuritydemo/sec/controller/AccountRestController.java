package com.example.springsecuritydemo.sec.controller;

import com.example.springsecuritydemo.sec.entity.AppRole;
import com.example.springsecuritydemo.sec.entity.AppUser;
import com.example.springsecuritydemo.sec.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/users")
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>>getAllUsers(){
        return  ResponseEntity.ok(accountService.listUsers());
    }

    @PostMapping
    public ResponseEntity<AppUser>addUser(@RequestBody AppUser appUser){
        return ResponseEntity.ok(accountService.addUser(appUser));
    }
    @PostMapping
    public ResponseEntity<AppRole>addRole(@RequestBody AppRole appRole){
        return ResponseEntity.ok(accountService.addRole(appRole));
    }

}
