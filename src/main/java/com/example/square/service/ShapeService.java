package com.example.square.service;

import com.example.square.model.FigureType;
import com.example.square.request.FigureRequest;

public interface ShapeService {
    int calculateSquare(FigureType figureType, FigureRequest figureRequest);
}
