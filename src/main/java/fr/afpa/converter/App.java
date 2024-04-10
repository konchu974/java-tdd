package fr.afpa.converter;

import fr.afpa.converter.view.ConverterPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        var converterView = new ConverterPane();

        Scene scene = new Scene(converterView);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}