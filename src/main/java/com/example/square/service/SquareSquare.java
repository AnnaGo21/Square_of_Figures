package com.example.square.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;

public class SquareSquare implements ShapeService{

    @JsonProperty("side")
    private int side;

    public SquareSquare(int side) {
        this.side = side;
    }

    @Override
    public int calculateSquare() {
        return side * side;
    }
}
