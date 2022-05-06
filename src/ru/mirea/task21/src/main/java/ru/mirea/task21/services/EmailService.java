package ru.mirea.task21.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class EmailService {

    public final String addressee = "zhuravliov.pav@yandex.ru";
    @Value("${spring.mail.username}")
    private String sender;
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotification(Object o) throws MailException {
        System.out.println("!!! Email !!!");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(addressee);
        mail.setFrom(sender);
        mail.setSubject("Save new " + o.getClass().getSimpleName() + " at " +
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .format(LocalDateTime.now()));
        mail.setText(o.toString());

        javaMailSender.send(mail);
        System.out.println("!!! Email are sent !!!");
    }
}