package com.example.prototype.Controller;


import com.example.prototype.fabric.CellFactory;
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
    private  Color color = new Color(0.7,0.7,0.7,1);
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
        Circle circle = new Circle(color, 3);
        Square square = new Square(color,1);
        Triangle triangle = new Triangle(color,1);
        Rectangle rectangle = new Rectangle(color,1);


        ListView<Shape> listViewShapes = new ListView<>();
        listViewShapes.setCellFactory(new CellFactory<>());
        contentShapes = FXCollections.observableArrayList();
        contentShapes.addAll(circle,square,rectangle,triangle);
        listViewShapes.setItems(contentShapes);

        listViewShapes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listShapes.setContent(listViewShapes);

        Sweet brush1 = new Sweet(color,1);
        Just brush2 = new Just(color,1);
        Ease brush3 = new Ease(Color.WHITE,1);
        ListView<Shape> ListViewBrushes = new ListView<>();
        ListViewBrushes.setCellFactory(new CellFactory<>());
        contentBrushes = FXCollections.observableArrayList();
        contentBrushes.setAll(brush1,brush2,brush3);
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