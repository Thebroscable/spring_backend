package com.example.demo.controller;

import com.example.demo.dto.response.UserAccountResponse;
import com.example.demo.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(path = "/user_account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @GetMapping("/{userAccountId}")
    public ResponseEntity<UserAccountResponse> getUserAccountById(@PathVariable Long userAccountId) {
        return ResponseEntity.ok(userAccountService.getUserAccountById(userAccountId));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserAccountResponse>> getAllUserAccount() {
        return ResponseEntity.ok(userAccountService.getAllUserAccount());
    }
}
