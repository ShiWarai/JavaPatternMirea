package ru.mirea.Task6.Prototype;

public class ArmoredVehicle implements Cloneable{

    protected String name;

    @Override
    protected ArmoredVehicle clone(){

        ArmoredVehicle clone = null;

        try{
            clone = (ArmoredVehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
