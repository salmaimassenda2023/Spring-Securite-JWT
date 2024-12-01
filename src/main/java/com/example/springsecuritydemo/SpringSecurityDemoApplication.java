package com.example.springsecuritydemo;

import com.example.springsecuritydemo.sec.entity.AppRole;
import com.example.springsecuritydemo.sec.entity.AppUser;
import com.example.springsecuritydemo.sec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            //add roles
            accountService.addRole(new AppRole(null,"admin"));
            accountService.addRole(new AppRole(null,"user"));
            accountService.addRole(new AppRole(null,"Costumer_Manager"));
            accountService.addRole(new AppRole(null,"Product_Manager"));
            accountService.addRole(new AppRole(null,"Bills_Manager"));
            // add users
            accountService.addUser(new AppUser(null,"user1","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"user2","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"user3","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"user4","1234",new ArrayList<>()));
            accountService.addUser(new AppUser(null,"admin","1234",new ArrayList<>()));
            //affecter les users a des roles
            accountService.addRoleToUser("user1","user");

            accountService.addRoleToUser("user2","user");
            accountService.addRoleToUser("user2","Costumer_Manager");

            accountService.addRoleToUser("user3","user");
            accountService.addRoleToUser("user3","Product_Manager");

            accountService.addRoleToUser("user4","user");
            accountService.addRoleToUser("user4","Bills_Manager");

            accountService.addRoleToUser("admin","admin");
            accountService.addRoleToUser("admin","user");



        };

    }}
