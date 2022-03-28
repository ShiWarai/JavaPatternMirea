package ru.mirea.task7.Adapter;

public class USB implements USBConnection {

    private byte[] buffer;
    private int port;

    USB(int port)
    {
        this.port = port;
    }

    @Override
    public void write(byte[] message) {
        System.out.println("Send bytes...");
    }

    @Override
    public byte[] read() {
        System.out.println("Read bytes...");
        return new byte[0];
    }
}
