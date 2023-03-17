package com.example.demo.constant;

import lombok.Getter;

@Getter
public enum RoleName {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String role;

    RoleName(String role) {
        this.role = role;
    }
}
