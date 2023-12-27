package com.example.prototype;

import com.example.prototype.shapes.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class ShapeListCellFactory implements Callback<ListView<Shape>, ListCell<Shape>> {

    @Override
    public ListCell<Shape> call(ListView<Shape> listView) {
        return new ListCell<>() {
            private final StackPane stackPane = new StackPane();
            private final Canvas canvas = new Canvas(20, 20);
            private final GraphicsContext gc = canvas.getGraphicsContext2D();

            {
                stackPane.getChildren().add(canvas);
            }

            @Override
            protected void updateItem(Shape shape, boolean empty) {
                super.updateItem(shape, empty);

                if (empty || shape == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    shape.setXY(10, 10);
                    shape.setSize(0.5);
                    // Рисование иконки на Canvas
                    shape.draw(gc);
                    setGraphic(stackPane);
                    setText(shape.toString());
                }
            }
        };
    }
}