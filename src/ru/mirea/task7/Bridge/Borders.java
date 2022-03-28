package ru.mirea.task7.Bridge;

public class Borders implements Line
{
    Integer[][] angles;

    @Override
    public void draw() {
        System.out.println("Draw a closed line");
    }
}
