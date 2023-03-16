package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    public Set<UserRole> findByName(String name);
}
