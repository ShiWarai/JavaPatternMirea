package ru.mirea.task5;

public class SingletonClass1 {

    private static SingletonClass1 singleObject;
    private SingletonClass1(){};

    public static synchronized SingletonClass1 getObject(){
        if(singleObject != null)
            return singleObject;

        singleObject = new SingletonClass1();
        return singleObject;
    }
}
