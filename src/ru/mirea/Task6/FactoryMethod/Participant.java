package ru.mirea.Task6.FactoryMethod;

public abstract class Participant {
    protected String name;
    protected long id;

    public abstract boolean getAccess(Door door);

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
