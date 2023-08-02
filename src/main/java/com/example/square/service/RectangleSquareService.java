package com.example.square.service;

import com.example.square.model.FigureType;
import com.example.square.request.FigureRequest;
import org.springframework.stereotype.Service;

@Service
public class RectangleSquareService implements ShapeService{
    @Override
    public int calculateSquare(FigureType figureType, FigureRequest figureRequest) {
//        RectangleRequest rectangleRequest = (RectangleRequest) figureRequest;
        if(figureType != FigureType.RECTANGLE){
            throw new IllegalArgumentException("Wrong type for Rectangle Square Calculations");
        }
        int length = figureRequest.getLength();
        int width = figureRequest.getWidth();

        if(length <= 0 || width <= 0){
            throw new IllegalArgumentException("Only positive integers are required!");
        }
        return length * width;
    }
}
