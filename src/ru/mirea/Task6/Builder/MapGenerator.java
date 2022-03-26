package ru.mirea.Task6.Builder;

import java.util.Random;

public interface MapGenerator {

    public void generateBorders(long bordersSeed);
    public void generateFields(String fieldsSeed);
    public void generateFlora(String floraSeed);
    public Map getResult();
}
