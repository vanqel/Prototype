package com.example.prototype.brushs;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Ease extends Brush implements Cloneable{
    public Ease(Color color, double size) {
        super(color, size);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(2.0);
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.WHITE);
        double wight = 20;
        gc.fillRect((x - wight/2*size), y- wight/2*size, wight*size, wight*size);
    }
    @Override
    public String toString() {
        return "Ластик";
    }

    @Override
    public Ease clone() {
        return (Ease) super.clone();
    }

}
