package ru.mirea.task5;

// Ну хоть это работает
public class SingletonClass4 {
    private static final SingletonClass4 singleObject = new SingletonClass4();
    private SingletonClass4(){};

    public static SingletonClass4 getObject(){
        return singleObject;
    }
}
