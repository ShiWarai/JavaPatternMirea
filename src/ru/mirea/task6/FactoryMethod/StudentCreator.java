package ru.mirea.task6.FactoryMethod;

import java.util.List;

import static java.lang.Math.abs;

public class StudentCreator extends Creator {

    public Participant createParticipant(String name) {
        Student student = new Student(abs(idGenerator.nextLong()));
        student.setName(name);

        return student;
    }

    public Participant createParticipant(String name, List<Door> doors){
        Student student = (Student) createParticipant(name);

        for (Door door:doors) {
            door.allowedIds.add(student.getId());
        }

        return student;
    }
}
