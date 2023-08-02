package com.example.square.request;

import lombok.Data;

@Data
public class RectangleRequest extends FigureRequest {
    int width;
    int length;
}
