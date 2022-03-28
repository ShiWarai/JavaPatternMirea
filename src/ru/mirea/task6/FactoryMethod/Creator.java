package ru.mirea.task6.FactoryMethod;

import java.util.Random;

public abstract class Creator {
    protected final Random idGenerator = new Random();
    public abstract Participant createParticipant(String name);
}
