package ru.mirea.task6.AbstractFactory;

public class Background extends Sprite{

    private String title;
    private String text;
    private Sprite backImage;

    public Background(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public void draw() {
        System.out.println(this.title);
        System.out.println(this.text);
        this.backImage.draw();
    }
}
