package ru.mirea.task14.Application;

public class Address {
    private String addressText, zipCode;

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressText='" + addressText + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
