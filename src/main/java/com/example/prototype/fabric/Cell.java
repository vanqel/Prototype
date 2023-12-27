package com.example.prototype.fabric;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Cell {
    Color getColor();
    void setXY(double X, double Y);
    void setSize(double x);
    void draw(GraphicsContext gc);
}
