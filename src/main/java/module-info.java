module com.example.prototype {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.prototype to javafx.fxml;
    exports com.example.prototype;
    exports com.example.prototype.shapes;
    opens com.example.prototype.shapes to javafx.fxml;
    exports com.example.prototype.Controller;
    opens com.example.prototype.Controller to javafx.fxml;
}