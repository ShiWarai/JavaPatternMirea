package ru.mirea.Task6.AbstractFactory;

public class MainScreenRender implements AbstractScreenRender{

    @Override
    public Sprite[] generateStatics() {
        return new Sprite[] { new Background("Welcome!", "New game") };
    }

    @Override
    public Animation[] generateDynamics() {
        return new Animation[] { new LoadingScreen("Loading...") };
    }
}
