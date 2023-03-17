package com.example.demo.user;

import com.example.demo.constant.MessageConstant;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByEmail() {
        String email = "michal@gmail.com";

        UserAccount userAccount = UserAccount.builder()
                .email(email)
                .password("qwerty")
                .build();
        underTest.save(userAccount);

        Optional<UserAccount> user = underTest.findByEmail(email);
        Assertions.assertTrue(user.isPresent(), MessageConstant.USER_DOES_NOT_EXISTS);
        Assertions.assertEquals(user.get().getEmail(), email, MessageConstant.VALUES_ARE_NOT_EQUAL);
    }

    @Test
    void NotFindByEmail() {
        String email = "michal@gmail.com";

        Optional<UserAccount> user = underTest.findByEmail(email);
        Assertions.assertFalse(user.isPresent(), MessageConstant.USER_EXISTS);
    }

    @Test
    void existsByEmail() {
        String email = "michal@gmail.com";

        UserAccount userAccount = UserAccount.builder()
                .email(email)
                .password("qwerty")
                .build();
        underTest.save(userAccount);

        Boolean userExists = underTest.existsByEmail(email);
        Assertions.assertTrue(userExists, MessageConstant.USER_DOES_NOT_EXISTS);
    }

    @Test
    void NotExistsByEmail() {
        String email = "michal@gmail.com";

        Boolean userExists = underTest.existsByEmail(email);
        Assertions.assertFalse(userExists, MessageConstant.USER_EXISTS);
    }
}
