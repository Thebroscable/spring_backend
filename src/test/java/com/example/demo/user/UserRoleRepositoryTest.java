package com.example.demo.user;

import com.example.demo.constant.RoleName;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

@DataJpaTest
public class UserRoleRepositoryTest {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    void ShouldFindByName() {
        String role = RoleName.ROLE_USER.getRole();

        UserRole userRole = UserRole.builder()
                .name(role)
                .description("random description")
                .build();
        userRoleRepository.save(userRole);

        Set<UserRole> userRoles = userRoleRepository.findByName(role);
        Assertions.assertEquals(userRoles.size(), 1);
        Assertions.assertEquals(userRoles.iterator().next().getName(), role);
    }
}
