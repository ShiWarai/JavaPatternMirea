package ru.mirea.task8.Command;

public class TurnOfCookerCommand implements Command{
    private Cooker cooker;

    public TurnOfCookerCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void execute() {
        cooker.turnOff();
    }
}