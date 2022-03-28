package ru.mirea.task8.Command;

public class TurnOnCookerCommand implements Command{
    private  Cooker cooker;

    public TurnOnCookerCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void execute() {
        cooker.turnOn();
    }
}