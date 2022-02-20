package ru.mirea.task3;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws Exception {

        Set<Integer> set = new SyncSet<Integer>();
        List<Integer> list = new SyncList<Integer>();

        Thread one = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                set.add(i);
                list.add(i);
            }
        });

        Thread two = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                set.add(i);
                list.add(i);
            }
        });

        one.start();
        two.start();
        Thread.sleep(1000);

        System.out.println("Set:");
        for (Integer e:set) {
            System.out.println(e);
        }

        System.out.println("List:");
        for (Integer e:list) {
            System.out.println(e);
        }
    }
}
