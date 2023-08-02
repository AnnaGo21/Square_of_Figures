package com.example.square.service;

import jakarta.validation.constraints.Positive;

public class SquareSquare implements ShapeService{

    @Positive(message = "Side length must be a positive value.")
    private int side;

    public SquareSquare(int side) {
        this.side = side;
    }

    @Override
    public int calculateSquare() {
        return side * side;
    }
}
