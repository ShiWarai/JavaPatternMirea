package ru.mirea.Task6.Builder;

public class DesertGenerator implements MapGenerator{

    long borders;
    String field;

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
        System.out.println("Nothing to generate!");
    }

    @Override
    public Map getResult() {
        Map map = new Map();
        map.borders = borders;
        map.field = field;

        return map;
    }
}
