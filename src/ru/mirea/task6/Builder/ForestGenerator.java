package ru.mirea.Task6.Builder;

public class ForestGenerator implements MapGenerator{

    long borders;
    String field;
    String trees;

    @Override
    public void generateBorders(long bordersSeed) {
        System.out.println("Generate borders by seed");
        borders = bordersSeed;
    }

    @Override
    public void generateFields(String fieldsSeed) {
        System.out.println("Generate fields by seed");
        field = fieldsSeed;
    }

    @Override
    public void generateFlora(String floraSeed) {
        System.out.println("Generate flora by seed!");
        trees = floraSeed;
    }

    @Override
    public Map getResult() {
        Map map = new Map();
        map.borders = borders;
        map.field = field;
        map.flora = trees;

        return map;
    }
}
