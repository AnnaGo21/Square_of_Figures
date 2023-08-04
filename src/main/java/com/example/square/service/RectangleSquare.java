package com.example.square.service;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;

public class RectangleSquare implements ShapeService{

    @JsonProperty("length")
    private int length;

    @JsonProperty("width")
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
