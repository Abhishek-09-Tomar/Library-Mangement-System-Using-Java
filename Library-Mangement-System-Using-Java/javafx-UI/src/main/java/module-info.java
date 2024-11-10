module com.example.javafxui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.javafxui to javafx.fxml;
    exports com.example.javafxui;
}