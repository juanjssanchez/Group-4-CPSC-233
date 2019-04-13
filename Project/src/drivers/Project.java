package drivers;

import gui.FirstScene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

//Project started from Session Three as a foundation:
//https://www.dropbox.com/sh/ladjdt873r09yb3/AABiKWwhQJghfboPZLuAJiVsa?dl=0&preview=SessionThree.zip

public class Project extends Application {
    private Stage stage;

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    //Sets javafx window title to "Group 4 Project"
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Group 4 Project");
        stage.show();

        FirstScene scene = new FirstScene(this);
        scene.setup();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
