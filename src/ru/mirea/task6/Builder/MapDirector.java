package ru.mirea.task6.Builder;

import java.util.Random;

public class MapDirector {

    Random random = new Random();

    public Map generateForest(){
        ForestGenerator generator = new ForestGenerator();
        generator.generateBorders(random.nextLong());
        generator.generateFields("fgsgfsdcdfdf32e");
        generator.generateFlora("dark wood");
        return generator.getResult();
    }

    public Map generateDesert(){
        DesertGenerator generator = new DesertGenerator();
        generator.generateBorders(random.nextLong());
        generator.generateFields("jl6432ovbzj2n4qr");
        return generator.getResult();
    }
}
