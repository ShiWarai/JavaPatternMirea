package ru.mirea.task24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.mirea.task24.repositories.UserRepository;
import ru.mirea.task24.tables.User;

@ExtendWith(MockitoExtension.class)
class UserAppServiceTest {
    @Mock
    private UserRepository userRepository;

    UserAppService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserAppService(new BCryptPasswordEncoder(10), userRepository);
    }

    @Test
    public void getUsers() {
        User user = new User();
        user.setUsername("user");

        Mockito.when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        Assertions.assertEquals(user.getUsername(), underTest.loadUserByUsername(user.getUsername()).getUsername());
    }

}