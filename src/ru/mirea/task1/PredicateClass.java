package ru.mirea.task1;

import java.util.function.Predicate;


public class PredicateClass implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        for(int i = 0; i < 32; i++){
            if(integer == Math.pow(2, i))
                return true;
        }

        return false;
    }
}