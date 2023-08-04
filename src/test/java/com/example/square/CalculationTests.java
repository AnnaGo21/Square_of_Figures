package com.example.square;

import com.example.square.controller.SquareController;
import com.example.square.request.ShapeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculationTests {
    @Autowired
    private MockMvc mockMvc;

    private SquareController squareController;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        squareController = new SquareController();
    }

    @Test
    public void testCalculateAreaWithValidTriangle() {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("triangle");
        shapeRequest.setDimensions(new int[]{5,4});

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

        assertThrows(IllegalArgumentException.class, () -> squareController.calculateSquare(shapeRequest));
    }

    @Test
    public void testCalculateAreaWithInvalidTriangleDimensions() throws Exception {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("triangle");
        shapeRequest.setDimensions(new int[]{5, -2});

        String shapeRequestJsonString = objectMapper.writeValueAsString(shapeRequest);

        mockMvc.perform(post("/square/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(shapeRequestJsonString))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCalculateAreaWithInvalidSquareDimensions() throws Exception {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("square");
        shapeRequest.setDimensions(new int[]{0});

        String shapeRequestJsonString = objectMapper.writeValueAsString(shapeRequest);

        mockMvc.perform(post("/square/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(shapeRequestJsonString))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCalculateAreaWithInvalidRectangleDimensions() throws Exception {
        ShapeRequest shapeRequest = new ShapeRequest();
        shapeRequest.setType("rectangle");
        shapeRequest.setDimensions(new int[]{4, -3});

        String shapeRequestJsonString = objectMapper.writeValueAsString(shapeRequest);
        mockMvc.perform(post("/square/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(shapeRequestJsonString))
                .andExpect(status().isBadRequest());
    }
}
