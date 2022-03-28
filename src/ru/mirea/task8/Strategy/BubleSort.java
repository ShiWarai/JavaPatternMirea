package ru.mirea.task8.Strategy;

import java.util.List;

public class BubleSort implements SortStrategy
{
    @Override
    public List<Comparable> sort(List<Comparable> list) {
        int n = list.size();

        Comparable temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(list.get(j-1).compareTo(j) < 0){
                    temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
