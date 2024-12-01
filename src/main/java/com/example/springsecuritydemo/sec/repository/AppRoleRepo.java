package com.example.springsecuritydemo.sec.repository;

import com.example.springsecuritydemo.sec.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
