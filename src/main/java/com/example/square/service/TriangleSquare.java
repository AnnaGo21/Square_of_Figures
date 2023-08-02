package com.example.square.service;

import com.example.square.model.FigureType;
import com.example.square.request.FigureRequest;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

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
