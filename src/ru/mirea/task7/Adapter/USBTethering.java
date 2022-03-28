package ru.mirea.task7.Adapter;

import java.nio.charset.StandardCharsets;

public class USBTethering implements Network {

    String address;
    USB usb_port;

    USBTethering(USB usb_port){
        this.address = "192.168.0.1";
        this.usb_port = usb_port;
    }

    @Override
    public void sendMessage(String message) {
        usb_port.write(message.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String receiveMessage() {
        return usb_port.read().toString();
    }
}
