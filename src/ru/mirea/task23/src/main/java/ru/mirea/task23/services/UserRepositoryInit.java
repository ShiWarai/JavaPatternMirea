package ru.mirea.task23.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.task23.repositories.UserRepository;
import ru.mirea.task23.tables.User;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class UserRepositoryInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AtomicLong counter = new AtomicLong();

    @Autowired
    public UserRepositoryInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Insert users");
        this.userRepository.deleteAll();
        User user = new User(counter.incrementAndGet(), "shiwarai", passwordEncoder.encode("shiwarai"));

        userRepository.save(user);
    }
}