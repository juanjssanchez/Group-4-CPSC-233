package gui;

import drivers.Project;
import handlers.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class FirstScene extends BaseScene {

    public FirstScene(Project game) {
        super(game);
    }

    @Override
    public void setup() {
        //Create buttons//
        Button m1btn = new Button("Monster 1");        //Monster buttons//
        Button m2btn = new Button("Monster 2");
        Button m3btn = new Button("Monster 3");
        Button bigbossbtn = new Button("Final Boss");
        Button quitbtn = new Button("Quit");

        //Images for the buttons//
        Image quitImg = new Image("file:img/Run.png");
        quitbtn.setGraphic(new ImageView(quitImg));

        Image enem2Img = new Image("file:img/enemy2.png");
        m1btn.setGraphic(new ImageView(enem2Img));
        m2btn.setGraphic(new ImageView(enem2Img));
        m3btn.setGraphic(new ImageView(enem2Img));

        Image enem1Img = new Image("file:img/enemy1.png");
        bigbossbtn.setGraphic(new ImageView(enem1Img));


        //Add buttons to HBox//
        VBox box = new VBox();

        box.setSpacing(10.0);

        box.getChildren().add(m1btn);
        box.getChildren().add(m2btn);
        box.getChildren().add(m3btn);
        box.getChildren().add(bigbossbtn);
        box.getChildren().add(quitbtn);
        box.setAlignment(Pos.CENTER);

        //Add Hbox to pane//
        StackPane pane = new StackPane();
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);

        //Attach event handlers to buttons//
        QuitBtnHandler qHandler = new QuitBtnHandler();
        quitbtn.setOnAction(qHandler);

        MonsterBtnHandler oneHandler = new MonsterBtnHandler(getGame());
        m1btn.setOnAction(oneHandler);
        m2btn.setOnAction(oneHandler);
        m3btn.setOnAction(oneHandler);
        bigbossbtn.setOnAction(oneHandler);


        //Set Scene//
        setScene(new Scene(pane, 600, 500));
        display();
    }

}
