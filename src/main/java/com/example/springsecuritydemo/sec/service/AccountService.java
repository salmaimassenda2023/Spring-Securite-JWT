package com.example.springsecuritydemo.sec.service;

import com.example.springsecuritydemo.sec.entity.AppRole;
import com.example.springsecuritydemo.sec.entity.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addUser(AppUser user);
    AppRole addRole(AppRole role);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}

