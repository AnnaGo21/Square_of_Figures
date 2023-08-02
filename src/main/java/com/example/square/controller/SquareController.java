package com.example.square.controller;

import com.example.square.exception.InvalidRequestException;
import com.example.square.model.FigureType;
import com.example.square.request.FigureRequest;
import com.example.square.service.RectangleSquareService;
import com.example.square.service.SquareSquareService;
import com.example.square.service.TriangleSquareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/square")
public class SquareController {
    private final TriangleSquareService triangleSquareService;
    private final SquareSquareService squareSquareService;
    private final RectangleSquareService rectangleSquareService;

    public SquareController(TriangleSquareService triangleSquareService, SquareSquareService squareSquareService,
                            RectangleSquareService rectangleSquareService) {
        this.triangleSquareService = triangleSquareService;
        this.squareSquareService = squareSquareService;
        this.rectangleSquareService = rectangleSquareService;
    }


    @PostMapping("/calculate")
    public ResponseEntity<Integer> calculateSquare(@RequestParam FigureType figureType,
                                                   @RequestBody FigureRequest figureRequest) {
        try {
            if(figureRequest == null){
                throw new InvalidRequestException("Figure request missing");
            }
            int square;
            switch (figureType){
                case TRIANGLE:
                    square = triangleSquareService.calculateSquare(figureType, figureRequest);
                    break;
                case SQUARE:
                    square = squareSquareService.calculateSquare(figureType, figureRequest);
                    break;
                case RECTANGLE:
                    square = rectangleSquareService.calculateSquare(figureType, figureRequest);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type for figure");
            }
            return ResponseEntity.ok(square);
        } catch (InvalidRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
