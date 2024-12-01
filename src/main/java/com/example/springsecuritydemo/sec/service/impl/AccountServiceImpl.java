package com.example.springsecuritydemo.sec.service.impl;

import com.example.springsecuritydemo.sec.entity.AppRole;
import com.example.springsecuritydemo.sec.entity.AppUser;
import com.example.springsecuritydemo.sec.repository.AppRoleRepo;
import com.example.springsecuritydemo.sec.repository.AppUserRepo;
import com.example.springsecuritydemo.sec.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepo appUserRepo;
    private AppRoleRepo appRoleRepo;

    @Autowired
    public AccountServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
    }

    //Methods Impl
    @Override
    public AppUser addUser(AppUser user) {

        return appUserRepo.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return appRoleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        AppRole appRole=appRoleRepo.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {

        return appUserRepo.findAll();
    }
}

