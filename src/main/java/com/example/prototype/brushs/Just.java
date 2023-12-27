package com.example.prototype.brushs;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Just extends Brush implements Cloneable{
    public Just(Color color, double size) {
        super(color, size);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);
        gc.setFill(color);
        gc.fillOval(x - Math.random()*15, y-Math.random()*15, 10*size/5, 10*size/5);

    }
    @Override
    public String toString() {
        return "Перо";
    }

    @Override
    public Just clone() {
        return (Just) super.clone();
    }

}
