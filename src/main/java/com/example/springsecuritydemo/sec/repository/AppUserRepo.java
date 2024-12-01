package com.example.springsecuritydemo.sec.repository;

import com.example.springsecuritydemo.sec.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
