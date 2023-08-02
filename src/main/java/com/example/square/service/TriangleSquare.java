package com.example.square.service;

import jakarta.validation.constraints.Positive;

public class TriangleSquare implements ShapeService{

    @Positive(message = "Base must be a positive value.")
    private int base;

    @Positive(message = "Height must be a positive value.")
    private int height;

    public TriangleSquare(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public int calculateSquare() {
        return (base * height) / 2;
    }
}
