package ru.mirea.Task6.FactoryMethod;

public class Student extends Participant {
    public Student(long id){
        this.id = id;
    }

    @Override
    public boolean getAccess(Door door) {
        return door.hasAccess(this);
    }
}
