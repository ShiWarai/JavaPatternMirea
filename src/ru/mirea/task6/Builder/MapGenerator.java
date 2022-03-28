package ru.mirea.task6.Builder;

public interface MapGenerator {

    public void generateBorders(long bordersSeed);
    public void generateFields(String fieldsSeed);
    public void generateFlora(String floraSeed);
    public Map getResult();
}
