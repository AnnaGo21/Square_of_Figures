package com.example.square.service;

import com.example.square.model.FigureType;
import com.example.square.request.FigureRequest;
import org.springframework.stereotype.Service;

@Service
public class TriangleSquareService implements ShapeService{

    @Override
    public int calculateSquare(FigureType figureType, FigureRequest figureRequest) {
//        TriangleRequest triangleRequest = (TriangleRequest) figureRequest;
        if(figureType != FigureType.TRIANGLE){
            throw new IllegalArgumentException("Wrong type for Triangle Square Calculations");
        }
        int base = figureRequest.getBase();
        int height = figureRequest.getHeight();

        if(base <= 0 || height <= 0){
            throw new IllegalArgumentException("Only positive integers are required!");
        }
        return (base * height) / 2;
    }
}
