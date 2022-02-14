package ru.mirea.task2;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    public int age;
    public String firstName;
    public String lastName;
    public LocalDate birthData;
    public int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthData, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthData = birthData;
        this.weight = weight;

        // Здесь по хорошему нужна проверка возраста, но ладно
    }

    public Human(String firstName, String lastName, LocalDate birthData, int weight){
        this.age = Period.between(birthData, LocalDate.now()).getYears(); // Расчитаем возраст по дате рождения
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthData = birthData;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Human %s %s", this.firstName, this.lastName);
    }
}
