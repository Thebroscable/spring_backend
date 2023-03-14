package com.example.demo.dto.response;

import com.example.demo.entity.UserAccount;
import lombok.Getter;

@Getter
public class UserAccountResponse {

    private Long id;

    private String email;

    private String password;

    public UserAccountResponse(UserAccount userAccount) {
        id = userAccount.getId();
        email = userAccount.getEmail();
        password = userAccount.getPassword();
    }
}
