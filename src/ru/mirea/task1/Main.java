package ru.mirea.task1;

import java.util.Scanner;

public class Main {

    static private Scanner input = new Scanner(System.in);

    static public void main(String[] args){
        Integer number;

        PredicateClass tester = new PredicateClass();

        number = input.nextInt();
        System.out.println("Является ли число " + number.toString() + " степенью двойки?");
        System.out.println(tester.test(number));

        return;
    }
}
