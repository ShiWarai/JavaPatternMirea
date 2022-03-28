package ru.mirea.task6.FactoryMethod;
import java.util.ArrayList;

public class Door {
    public final long number;
    public ArrayList<Long> allowedIds = new ArrayList<>(){};

    public Door(long id) {
        this.number = id;
    }

    public boolean hasAccess(Participant participant){
        return this.allowedIds.contains(participant.getId());
    }
}
