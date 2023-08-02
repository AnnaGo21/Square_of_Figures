package com.example.square.service;

import com.example.square.model.FigureType;
import com.example.square.request.FigureRequest;
import org.springframework.stereotype.Service;

@Service
public class SquareSquareService implements ShapeService{

    @Override
    public int calculateSquare(FigureType figureType, FigureRequest figureRequest) {
//        SquareRequest squareRequest = (SquareRequest) figureRequest;
        if(figureType != FigureType.SQUARE){
            throw new IllegalArgumentException("Wrong type for Square Square Calculations");
        }
        int side = figureRequest.getSide();

        if(side <= 0){
            throw new IllegalArgumentException("Only positive integer is required!");
        }
        return side * side;
    }
}
