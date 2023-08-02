package com.example.square;

import com.example.square.controller.SquareController;
import com.example.square.exception.InvalidDimensionsException;
import com.example.square.exception.InvalidRequestException;
import com.example.square.request.ShapeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationTests {

    private SquareController squareController;

    @BeforeEach
    public void setUp() {
        squareController = new SquareController();
    }

    @Test
    public void testCalculateAreaWithValidTriangle() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("triangle");
        shapeRequest.setDimensions(new int[]{5, 4});

        ResponseEntity<Integer> response = squareController.calculateSquare(shapeRequest);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10, response.getBody());
    }

    @Test
    public void testCalculateAreaWithValidSquare() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("square");
        shapeRequest.setDimensions(new int[]{5});

        ResponseEntity<Integer> response = squareController.calculateSquare(shapeRequest);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(25, response.getBody());
    }

    @Test
    public void testCalculateAreaWithValidRectangle() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("rectangle");
        shapeRequest.setDimensions(new int[]{4, 6});

        ResponseEntity<Integer> response = squareController.calculateSquare(shapeRequest);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(24, response.getBody());
    }

    @Test
    public void testCalculateAreaWithInvalidFigureType() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("circle");

        assertThrows(InvalidRequestException.class, () -> squareController.calculateSquare(shapeRequest));
    }

    @Test
    public void testCalculateAreaWithInvalidTriangleDimensions() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("triangle");
        shapeRequest.setDimensions(new int[]{5, -2});

        assertThrows(InvalidDimensionsException.class, () -> squareController.calculateSquare(shapeRequest));
    }

    @Test
    public void testCalculateAreaWithInvalidSquareDimensions() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("square");
        shapeRequest.setDimensions(new int[]{0});

        assertThrows(InvalidDimensionsException.class, () -> squareController.calculateSquare(shapeRequest));
    }

    @Test
    public void testCalculateAreaWithInvalidRectangleDimensions() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("rectangle");
        shapeRequest.setDimensions(new int[]{4, -3});

        assertThrows(InvalidDimensionsException.class, () -> squareController.calculateSquare(shapeRequest));
    }
}
