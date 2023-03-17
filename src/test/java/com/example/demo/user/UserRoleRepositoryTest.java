package com.example.demo.user;

import com.example.demo.constant.MessageConstant;
import com.example.demo.constant.RoleName;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

@DataJpaTest
public class UserRoleRepositoryTest {

    @Autowired
    private UserRoleRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void FindByNameExists() {
        String role = RoleName.ROLE_USER.getRole();

        UserRole userRole = UserRole.builder()
                .name(role)
                .description("random description")
                .build();
        underTest.save(userRole);

        Set<UserRole> userRoles = underTest.findByName(role);
        Assertions.assertEquals(userRoles.size(), 1, MessageConstant.VALUES_ARE_NOT_EQUAL);
        Assertions.assertEquals(userRoles.iterator().next().getName(), role, MessageConstant.VALUES_ARE_NOT_EQUAL);
    }

    @Test
    void FindByNameNotExists() {
        String role = RoleName.ROLE_USER.getRole();

        Set<UserRole> userRoles = underTest.findByName(role);
        Assertions.assertEquals(userRoles.size(), 0, MessageConstant.USER_EXISTS);
    }
}
