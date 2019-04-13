package gui;

import drivers.Project;
import handlers.QuitBtnHandler;
import handlers.RestartBtnHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class WinScene extends BaseScene {

    public WinScene(Project game) {
        super(game);
    }

    @Override
    public void setup() {
        Label label = new Label("You Win!");
        label.setScaleX(6.0);
        label.setScaleY(6.0);
        label.setLayoutY(10.0);

        Button quitbtn = new Button("Quit");
        Button restartbtn = new Button("Play Again");

        VBox box = new VBox();
        box.getChildren().addAll(label, quitbtn, restartbtn);
        box.setSpacing(100.0);
        box.setAlignment(Pos.CENTER);

        //Add Hbox to pane//
        StackPane pane = new StackPane();
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);

        //Attach event handlers to buttons//
        QuitBtnHandler qHandler = new QuitBtnHandler();
        quitbtn.setOnAction(qHandler);

        RestartBtnHandler rHandler = new RestartBtnHandler(getGame());
        restartbtn.setOnAction(rHandler);


        //Set Scene//
        setScene(new Scene(pane, 600, 500));
        display();

    }

}
