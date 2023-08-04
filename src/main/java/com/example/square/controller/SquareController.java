package com.example.square.controller;

import com.example.square.exception.InvalidDimensionsException;
import com.example.square.exception.InvalidRequestException;
import com.example.square.request.ShapeRequest;
import com.example.square.service.ShapeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/square")
public class SquareController {

    @PostMapping("/calculate")
    public ResponseEntity<Integer> calculateSquare(@RequestBody @Valid ShapeRequest shapeRequest) {
        ShapeService shape = shapeRequest.getShape();

        if (shape == null) {
            throw new InvalidRequestException("Invalid shape type.");
        }

        int area = shape.calculateSquare();
        return ResponseEntity.ok(area);
    }

    @ExceptionHandler(InvalidDimensionsException.class)
    public ResponseEntity<String> handleInvalidDimensionsException(InvalidDimensionsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

