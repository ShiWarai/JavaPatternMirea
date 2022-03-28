package ru.mirea.task7.Bridge;

import java.awt.*;

public abstract class ColorfulLine {
    protected Line line;

    ColorfulLine(Line line){
        this.line = line;
    }

    abstract void draw(Color color);
}
