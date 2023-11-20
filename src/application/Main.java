package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        changeScene("Sample.fxml");
    }

    public static SampleController changeScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 369, 525));
        primaryStage.show();

        return loader.getController();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
