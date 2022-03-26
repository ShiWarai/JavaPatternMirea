package ru.mirea.Task6.AbstractFactory;

public class SceneRender implements AbstractScreenRender {

    private Player player1;

    @Override
    public Sprite[] generateStatics() {
        return new Sprite[] { new Tree() };
    }

    @Override
    public Animation[] generateDynamics() {
        return new Animation[] { player1 };
    }
}
