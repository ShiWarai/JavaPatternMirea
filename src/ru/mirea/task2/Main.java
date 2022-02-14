package ru.mirea.task2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static private Scanner input = new Scanner(System.in);

    static public void main(String[] args){

        // Формируем список людей
        List<Human> people = new ArrayList<Human>();
        people.add(new Human("Pavel", "Zhuravlev", LocalDate.parse("2002-11-14"), 49));
        people.add(new Human(25, "Artur", "Efimov", LocalDate.parse("2000-09-05"), 72));
        people.add(new Human("Dmitry", "Zhukov", LocalDate.parse("1995-10-17"), 60));
        people.add(new Human("Victor", "Lomov", LocalDate.parse("1999-05-02"), 95));
        people.add(new Human("Alex", "Klochek", LocalDate.parse("2000-09-05"), 80));

        Stream<Human> peopleStream;

        // Работа каждого метода
        System.out.println("Сортируем...");
        peopleStream = people.stream().sorted((Human obj1, Human obj2) -> -(obj1.firstName.compareTo(obj2.firstName)));
        System.out.println(peopleStream.collect(Collectors.toList()));

        System.out.println("Фильтруем...");
        peopleStream = people.stream().filter((Human obj) -> obj.age > 20);
        System.out.println(peopleStream.collect(Collectors.toList()));

        System.out.println("Выбираем...");
        peopleStream = people.stream().limit(3);
        System.out.println(peopleStream.collect(Collectors.toList()));

        System.out.println("Конкатенируем...");
        System.out.println(people.stream().flatMap((Human obj) -> Arrays.asList(obj.firstName).stream())
                .reduce((String obj1, String obj2) -> obj1 + " " + obj2).get());

        /*  Сортируем по имени в обратном порядке, фильтруем по возрасту >20,
            выбираем 3 элемента из списка и конкатенериуем имена в строку через пробел последовательно */
        peopleStream = people.stream();
        peopleStream = peopleStream.sorted((Human obj1, Human obj2) -> -(obj1.firstName.compareTo(obj2.firstName)));
        peopleStream = peopleStream.filter((Human obj) -> obj.age > 20);
        peopleStream = peopleStream.limit(3);
        Optional<String> result = peopleStream.flatMap((Human obj) -> Arrays.asList(obj.firstName).stream())
                .reduce((String obj1, String obj2) -> obj1 + " " + obj2);

        System.out.println("\nРезультат обработки потока данных последовательно:");
        System.out.println(result.get()); // Вывод результата

        return;
    }
}
