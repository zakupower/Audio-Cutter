package audio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainApp.fxml"));
        primaryStage.setTitle("Audio Cutter");
        primaryStage.setScene(new Scene(root, 625, 450));
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(625);
        primaryStage.getIcons().add(new Image("file:ico3.png"));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
