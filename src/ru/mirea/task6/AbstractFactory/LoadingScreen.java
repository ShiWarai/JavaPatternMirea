package ru.mirea.task6.AbstractFactory;

public class LoadingScreen extends Animation{

    private String title;

    public LoadingScreen(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println(this.title);
        for (Sprite frame:this.frames)
            frame.draw();
    }
}
