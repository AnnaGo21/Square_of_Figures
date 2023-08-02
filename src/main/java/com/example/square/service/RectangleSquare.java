package com.example.square.service;


import jakarta.validation.constraints.Positive;

public class RectangleSquare implements ShapeService{

    @Positive(message = "Length must be a positive value")
    private int length;

    @Positive(message = "Width must be a positive value")
    private int width;

    public RectangleSquare(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int calculateSquare() {
        return length * width;
    }
}
