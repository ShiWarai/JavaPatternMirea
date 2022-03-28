package ru.mirea.Task6.AbstractFactory;

import java.awt.*;

public class Tree extends Sprite{

    public int[][] position;

    public Tree() {
        // Random generation
    }

    @Override
    public void draw() {
        System.out.println("Tree:");
        for (Color[] raw:this.pixels) {
            for (Color pixel:raw) {
                System.out.print(pixel.getRGB());
            }
            System.out.print('\n');
        }
    }
}
