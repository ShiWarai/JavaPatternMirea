package ru.mirea.task6.AbstractFactory;

interface AbstractScreenRender {
    public Sprite[] generateStatics();
    public Animation[] generateDynamics();
}
