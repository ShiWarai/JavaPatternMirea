package ru.mirea.Task6.AbstractFactory;

interface AbstractScreenRender {
    public Sprite[] generateStatics();
    public Animation[] generateDynamics();
}
