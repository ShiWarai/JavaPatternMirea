package ru.mirea.task4;

public class Main {

    public static void main(String[] args){
        ThreadController executorService = new ThreadController(2);
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));

        executorService.shutdown(); // ждём остановки всех задач
        return;
    }
}
