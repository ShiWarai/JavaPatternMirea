package ru.mirea.Task6.AbstractFactory;

public class Player extends Animation{

    public int[][] position;

    @Override
    public void play() {
        for (Sprite frame:this.frames)
            frame.draw();
    }
}
