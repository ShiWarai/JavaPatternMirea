package ru.mirea.task7.Bridge;

public class Track implements Line
{

    int[][] coords;

    @Override
    public void draw() {
        System.out.println("Draw a track");
    }
}
