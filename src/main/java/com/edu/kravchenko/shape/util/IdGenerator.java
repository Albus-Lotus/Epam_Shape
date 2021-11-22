package com.edu.kravchenko.shape.util;

public class IdGenerator {
    private static int counter;

    public IdGenerator() {
    }

    public static int generateId() {
        return counter++;
    }
}
