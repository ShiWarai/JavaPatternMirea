package ru.mirea.task6.FactoryMethod;

import static java.lang.Math.abs;

public class TeacherCreator extends Creator{
    public Participant createParticipant(String name) {
        Teacher teacher = new Teacher(-abs(idGenerator.nextLong()));
        teacher.setName(name);

        return teacher;
    }
}
