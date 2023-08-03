package com.example.square.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;

public class TriangleSquare implements ShapeService{

    @JsonProperty("base")
    private int base;

    @JsonProperty("height")
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
