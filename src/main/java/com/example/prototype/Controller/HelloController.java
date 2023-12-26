package com.example.prototype.Controller;

import com.example.prototype.brushs.Brush;
import com.example.prototype.brushs.Ease;
import com.example.prototype.brushs.Just;
import com.example.prototype.brushs.Sweet;
import com.example.prototype.shapes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Slider size;
    @FXML
    public TitledPane listBrushes;
    @FXML
    public TitledPane listShapes;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorSelect;
    private ObservableList contentShapes;
    private ObservableList contentBrushes;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Circle circle = new Circle(Color.RED, 1);
        Square square = new Square(Color.RED,1);
        Triangle triangle = new Triangle(Color.RED,1);
        Rectangle rectangle = new Rectangle(Color.RED,1);

        ListView<Shape> ListViewShapes = new ListView<>();
        contentShapes = FXCollections.observableArrayList();
        contentShapes.add(circle);
        contentShapes.add(square);
        contentShapes.add(rectangle);
        contentShapes.add(triangle);
        ListViewShapes.setItems(contentShapes);
        ListViewShapes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listShapes.setContent(ListViewShapes);

        Sweet brush1 = new Sweet(Color.BLACK,1);
        Just brush2 = new Just(Color.BLACK,1);
        Ease brush3 = new Ease(Color.WHITE,1);
        ListView ListViewBrushes = new ListView();
        contentBrushes = FXCollections.observableArrayList();
        contentBrushes.add(brush1);
        contentBrushes.add(brush2);
        contentBrushes.add(brush3);
        ListViewBrushes.setItems(contentBrushes);
        ListViewBrushes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listBrushes.setContent(ListViewBrushes);
    }

    @FXML
    protected void onHelloButtonClick() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,2620,7940);
    }


    public void drawShape(MouseEvent mouseEvent) {
        if (listShapes.isExpanded()){
            ListView listview = (ListView) listShapes.getContent();
            int index = listview.getSelectionModel().getSelectedIndex();
            if (index < 0){index = 0;}
            Shape shape = (Shape) contentShapes.get(index);
            shape = (Shape) shape.clone();
            shape.setColor(colorSelect.getValue());
            shape.setSize(size.getValue()/10);
            shape.setXY(mouseEvent.getX(), mouseEvent.getY());
            shape.draw(canvas.getGraphicsContext2D());
        }
    }
    public void drawLoop(MouseEvent mouseEvent) {
        if (listBrushes.isExpanded()){
            ListView listview = (ListView) listBrushes.getContent();
            int index = listview.getSelectionModel().getSelectedIndex();
            if (index < 0){index = 0;}
            Brush shape = (Brush) contentBrushes.get(index);
            shape = (Brush) shape.clone();
            shape.setColor(colorSelect.getValue());
            shape.setSize(size.getValue()/10);
            shape.setXY(mouseEvent.getX(), mouseEvent.getY());
            shape.draw(canvas.getGraphicsContext2D());
        }
    }
}