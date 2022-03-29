package ru.mirea.task10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.task10.Programmers.Junior;
import ru.mirea.task10.Programmers.Middle;
import ru.mirea.task10.Programmers.Senior;

@Configuration
public class ProgrammersConfiguration {

    @Bean("Junior")
    public Junior junior() {
        return new Junior();
    }

    @Bean("Middle")
    public Middle middle() {
        return new Middle();
    }

    @Bean("Senior")
    public Senior senior() {
        return new Senior();
    }
}
