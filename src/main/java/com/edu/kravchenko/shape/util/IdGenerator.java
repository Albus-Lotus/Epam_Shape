package com.edu.kravchenko.shape.util;

public class IdGenerator {
    private static long counter;

    public IdGenerator() {
    }

    public static long generateId() {
        return counter++;
    }
}
