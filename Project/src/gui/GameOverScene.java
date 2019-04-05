package gui;

import drivers.Project;
import handlers.QuitBtnHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class GameOverScene extends BaseScene {

    public GameOverScene(Project game) {
        super(game);
    }

    @Override
    public void setup() {
        Button quitbtn = new Button("Quit");
        HBox box = new HBox();
        box.getChildren().add(quitbtn);
        box.setAlignment(Pos.CENTER);        //Move buttons to middle//

        //Add Hbox to pane//
        StackPane pane = new StackPane();
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);

        //Attach event handlers to buttons//
        QuitBtnHandler qHandler = new QuitBtnHandler();
        quitbtn.setOnAction(qHandler);


        //Set Scene//
        setScene(new Scene(pane, 600, 500));
        display();

    }

}
