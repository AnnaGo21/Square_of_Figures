package com.example.square.request;

import com.example.square.exception.InvalidDimensionsException;
import com.example.square.exception.InvalidRequestException;
import com.example.square.model.FigureType;
import com.example.square.model.PositiveArray;
import com.example.square.service.RectangleSquare;
import com.example.square.service.ShapeService;
import com.example.square.service.SquareSquare;
import com.example.square.service.TriangleSquare;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ShapeRequest {
    private String type;

    @PositiveArray(message = "Dimension values must be positive values")
    private int[] dimensions;

    @JsonIgnore
    @JsonCreator
    public ShapeService getShape() {
        switch (FigureType.valueOf(type.toUpperCase())) {
            case TRIANGLE:
                if (dimensions.length != 2) {
                    throw new InvalidDimensionsException("Triangle requires two dimensions: base and height");
                }
                return new TriangleSquare(dimensions[0], dimensions[1]);
            case SQUARE:
                if (dimensions.length != 1) {
                    throw new InvalidDimensionsException("Square requires one dimension: side");
                }
                return new SquareSquare(dimensions[0]);
            case RECTANGLE:
                if (dimensions.length != 2) {
                    throw new InvalidDimensionsException("Rectangle requires two dimensions: length and width");
                }
                return new RectangleSquare(dimensions[0], dimensions[1]);
            default:
                throw new InvalidRequestException("Invalid shape type");
        }
    }
}
