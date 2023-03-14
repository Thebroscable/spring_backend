package com.example.demo.dto.response;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.UserRole;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class UserAccountResponse {

    private Long id;

    private String email;

    private String password;

    private List<String> userRoles = new ArrayList<>();

    public UserAccountResponse(UserAccount userAccount) {
        this.id = userAccount.getId();
        this.email = userAccount.getEmail();
        this.password = userAccount.getPassword();
        Set<UserRole> RoleSet = userAccount.getUserRoles();
        for (UserRole userRole : RoleSet) {
            this.userRoles.add(userRole.getName());
        }
    }
}
