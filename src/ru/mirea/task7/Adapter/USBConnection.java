package ru.mirea.task7.Adapter;

public interface USBConnection {
    void write(byte[] message);
    byte[] read();
}
