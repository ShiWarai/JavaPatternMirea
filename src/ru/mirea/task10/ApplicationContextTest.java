package ru.mirea.task10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea.task10.Programmers.Programmer;

public class ApplicationContextTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProgrammersConfiguration.class);

        String beanName = args[0];
        Programmer programmer = (Programmer) applicationContext.getBean(beanName);

        programmer.doCoding();
    }
}
