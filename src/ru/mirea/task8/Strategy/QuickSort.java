package ru.mirea.task8.Strategy;

import java.util.List;

public class QuickSort implements SortStrategy
{
    public List<Comparable> sort(List<Comparable> list, int low, int high) {

        if (list.size() == 0 || low >= high)
            return null;

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Comparable opora = list.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (list.get(i).compareTo(opora) > 0) {
                i++;
            }

            while (list.get(i).compareTo(opora) > 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                Comparable temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            return sort(list, low, j);

        if (high > i)
            return sort(list, i, high);

        return list;
    }

    @Override
    public List<Comparable> sort(List list) {
        return sort(list, 0, list.size());
    }
}
