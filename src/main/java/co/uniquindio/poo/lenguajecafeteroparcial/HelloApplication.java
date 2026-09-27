package co.uniquindio.poo.lenguajecafeteroparcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Cambiamos la ruta para que cargue tu interfaz principal
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/co/uniquindio/poo/lenguajecafeteroparcial/Gestion.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        // Actualizamos el título de la ventana
        stage.setTitle("Academia Lenguaje Cafetero");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}