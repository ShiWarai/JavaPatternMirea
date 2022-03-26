package ru.mirea.Task6.Prototype;

public class SovietFactory {
    protected APC apc;
    protected Tank tank;

    public SovietFactory(String apcName, String tankName){
        this.apc = new APC(apcName);
        this.tank = new Tank(tankName);
    }

    public Tank createTank(){
        return (Tank) tank.clone();
    }

    public APC createAPC(){
        return (APC) apc.clone();
    }
}
