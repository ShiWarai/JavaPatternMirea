package ru.mirea.Task6.FactoryMethod;

import java.util.Random;

public abstract class Creator {
    protected final Random idGenerator = new Random();
    public abstract Participant createParticipant(String name);
}
