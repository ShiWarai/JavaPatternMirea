package ru.mirea.task7.Bridge;

import java.awt.*;

public class Walk extends ColorfulLine{

    Walk(Line line) {
        super(line);
    }

    @Override
    void draw(Color color) {
        this.line.draw();
        System.out.println("Fill line by color: " + Integer.toString(color.getRGB()));
    }

}
