package com.example.skyprohomeworkalgorithmpart2.exception;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException() {
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
