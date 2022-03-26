package ru.mirea.Task6.FactoryMethod;

import ru.mirea.task5.SingletonClass4;

public class Main {
    public static void main(String[] args){
        TeacherCreator creator1 = new TeacherCreator();
        StudentCreator creator2 = new StudentCreator();

        Teacher teacher = (Teacher) creator1.createParticipant("Pavel");
        Student student = (Student) creator2.createParticipant("Oleg");

        Door door = new Door(1);

        System.out.println(teacher);
        System.out.println(student);
        System.out.println(teacher.getAccess(door));
        System.out.println(student.getAccess(door));

        return;
    }
}
