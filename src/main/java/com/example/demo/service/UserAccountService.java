package com.example.demo.service;

import com.example.demo.dto.response.UserAccountResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountResponse getUserAccountById(Long userAccountId) {
        UserAccount userAccount = userAccountRepository.getReferenceById(userAccountId);
        return new UserAccountResponse(userAccount);
    }

    public List<UserAccountResponse> getAllUserAccount() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();
        List<UserAccountResponse> userAccountResponses = new ArrayList<UserAccountResponse>();

        for (UserAccount userAccount : userAccounts) {
            userAccountResponses.add(new UserAccountResponse(userAccount));
        }

        return userAccountResponses;
    }
}
