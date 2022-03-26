package ru.mirea.task5;

/*
Собственная реализация
P.S. убогий язык со сборкой мусора не может даже ушедшие из области видимости объекты удалять
на плюсах бы сработало, идём дальше
*/
public class SingletonClass3 {

    private static boolean inSingleObjectExist = false;

    protected SingletonClass3(){
        inSingleObjectExist = true;
    };

    @Override
    public void finalize() throws Throwable {
        inSingleObjectExist = false;
        super.finalize();
    }

    public static SingletonClass3 createInstance(){
        return inSingleObjectExist ? null : new SingletonClass3();
    }
}


