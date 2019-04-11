package gui;

import drivers.Project;
import handlers.QuitBtnHandler;
import handlers.RestartBtnHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameOverScene extends BaseScene {

    public GameOverScene(Project game) {
        super(game);
    }

    @Override
    public void setup() {
        Label label = new Label("Game Over");
        label.setScaleX(6.0);
        label.setScaleY(6.0);
        label.setLayoutY(10.0);

        Button quitbtn = new Button("Quit");
        Button restartbtn = new Button("Play Again");
        
        Image quittingbtn = new Image("file:img/lost.gif",50,50,false,false);
        quitbtn.setGraphic(new ImageView(quittingbtn));
        Image restartingbtn = new Image("file:img/win.gif",50,50,false,false);
        restartbtn.setGraphic(new ImageView(restartingbtn));

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
        
        //set background image
        BackgroundImage myBI= new BackgroundImage(new Image("file:img/gameover.gif",600,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        //then you set to your node
        pane.setBackground(new Background(myBI));

        //Set Scene//
        setScene(new Scene(pane, 600, 500));
        display();

    }

}
