package gui;

import drivers.Project;
import handlers.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class FirstScene extends BaseScene {

    public FirstScene(Project game) {
        super(game);
    }

    @Override
    public void setup() {
        

        //Create buttons//
        Button m1btn = new Button("Monster 1(Easy)");        //Monster buttons//
        Button m2btn = new Button("Monster 2(Normal)");
        Button m3btn = new Button("Monster 3(Hard");
        Button bigbossbtn = new Button("Final Boss");
        Button quitbtn = new Button("Quit");

        //Images for the buttons//
        Image quitImg = new Image("file:img/run.gif",50,50,false,false);
        quitbtn.setGraphic(new ImageView(quitImg));
        Image enem1Img = new Image("file:img/monster1.gif",50,50,false,false);
        m1btn.setGraphic(new ImageView(enem1Img));
        Image enem2Img = new Image("file:img/monster2.gif",50,50,false,false);
        m2btn.setGraphic(new ImageView(enem2Img));
        Image enem3Img = new Image("file:img/monster3.gif",50,50,false,false);
        m3btn.setGraphic(new ImageView(enem3Img));
        Image enem4Img = new Image("file:img/boss.gif",50,50,false,false);
        bigbossbtn.setGraphic(new ImageView(enem4Img));


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
        
        //set background image
        BackgroundImage myBI= new BackgroundImage(new Image("file:img/backgroundmain.gif",600,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        //then you set to your node
        pane.setBackground(new Background(myBI));
        
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
