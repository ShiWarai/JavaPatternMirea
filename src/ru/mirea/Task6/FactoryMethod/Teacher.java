package ru.mirea.Task6.FactoryMethod;

public class Teacher extends Participant{
    public Teacher(long id){
        this.id = id;
    }

    @Override
    public boolean getAccess(Door door) {
        return true;
    }
}
