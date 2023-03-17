package com.example.demo.user;

import com.example.demo.dto.response.ProductCategoryResponse;
import com.example.demo.dto.response.UserAccountResponse;
import com.example.demo.entity.ProductCategory;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.assertj.core.api.Assertions;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserAccountRepository userAccountRepository;
    private UserAccountService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserAccountService(userAccountRepository);
    }

    @Test
    void getUserAccountById_PassValueProperly() {
        when(userAccountRepository.getReferenceById(any())).thenReturn(new UserAccount());
        underTest.getUserAccountById(1L);

        ArgumentCaptor<Long> argumentCaptor =
                ArgumentCaptor.forClass(Long.class);
        verify(userAccountRepository).getReferenceById(argumentCaptor.capture());
        Long capturedValue = argumentCaptor.getValue();

        Assertions.assertThat(capturedValue).isEqualTo(1L);
    }

    @Test
    void getUserAccountById_ReturnValueProperly() {
        Set<UserRole> roles = new HashSet<>();
        roles.add(new UserRole(1L, "admin", "desc"));
        UserAccount userAccount = UserAccount.builder()
                .id(1L)
                .email("test@gmail.com")
                .password("qwerty")
                .userRoles(roles)
                .build();
        UserAccountResponse baseResponse = new UserAccountResponse(userAccount);

        when(userAccountRepository.getReferenceById(any())).thenReturn(userAccount);
        UserAccountResponse response = underTest.getUserAccountById(1L);

        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(baseResponse);
    }

    @Test
    void getAllUserAccount() {
        Set<UserRole> roles = new HashSet<>();
        roles.add(new UserRole(1L, "admin", "desc"));
        UserAccount userAccount = UserAccount.builder()
                .id(1L)
                .email("test@gmail.com")
                .password("qwerty")
                .userRoles(roles)
                .build();
        List<UserAccount> accounts = new ArrayList<>();
        accounts.add(userAccount);

        UserAccountResponse baseResponse = new UserAccountResponse(userAccount);
        when(userAccountRepository.findAll()).thenReturn(accounts);

        List<UserAccountResponse> responses = underTest.getAllUserAccount();
        verify(userAccountRepository).findAll();

        Assertions.assertThat(!responses.isEmpty()).isTrue();
        Assertions.assertThat(responses.get(0))
                .usingRecursiveComparison()
                .isEqualTo(baseResponse);
    }
}
