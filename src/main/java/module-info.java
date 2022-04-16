module com.example.catanfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.catanfx to javafx.fxml;
    exports com.example.catanfx;
    exports com.example.catanfx.Controllers;
    opens com.example.catanfx.Controllers to javafx.fxml;
}