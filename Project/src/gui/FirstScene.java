package gui;

import drivers.Project;
import handlers.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logic.Human;
import logic.Player;
import gui.WinScene;


public class FirstScene extends BaseScene {

    private Button m1btn, m2btn, m3btn, bigbossbtn;
    private Player player;

    public FirstScene(Project game) {
        super(game);
        player = new Human(getGame());
    }

    @Override
    public void setup() {
        //Create buttons//
        m1btn = new Button("Monster 1");        //Monster buttons//
        m2btn = new Button("Monster 2");
        m3btn = new Button("Monster 3");
        bigbossbtn = new Button("Final Boss");
        Button quitbtn = new Button("Quit");

        //Images for the buttons//
        Image quitImg = new Image("file:img/Run.png");
        quitbtn.setGraphic(new ImageView(quitImg));

        Image enem1Img = new Image("file:img/monster1.gif", 50, 50, false, false);
        m1btn.setGraphic(new ImageView(enem1Img));
        Image enem2Img = new Image("file:img/monster2.gif", 50, 50, false, false);
        m2btn.setGraphic(new ImageView(enem2Img));
        Image enem3Img = new Image("file:img/monster3.gif", 50, 50, false, false);
        m3btn.setGraphic(new ImageView(enem3Img));
        Image enem4Img = new Image("file:img/boss.gif", 50, 50, false, false);
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

        BackgroundImage myBI = new BackgroundImage(new Image("file:img/backgroundmain.gif", 600, 500, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //then you set to your node
        pane.setBackground(new Background(myBI));

        //Attach event handlers to buttons//
        QuitBtnHandler qHandler = new QuitBtnHandler();
        quitbtn.setOnAction(qHandler);

        MonsterBtnHandler oneHandler = new MonsterBtnHandler(getGame(), this, player);
        m1btn.setOnAction(oneHandler);
        m2btn.setOnAction(oneHandler);
        m3btn.setOnAction(oneHandler);
        bigbossbtn.setOnAction(oneHandler);

        //Set Scene//
        setScene(new Scene(pane, 600, 500));
        display();
    }

    public void updateScene(String name) {
        if (name.equals("Monster 1")) {
            m1btn.setDisable(true);
            player.setHealth(player.getHealth() + 50); //gain 50 health if you beat monsters
            player.setAttack(20);   //gain stronger attack
            display();

        }
        if (name.equals("Monster 2")) {
            m2btn.setDisable(true);
            player.setHealth(player.getHealth() + 50);
            player.setAttack(25);
            display();

        }
        if (name.equals("Monster 3")) {
            m3btn.setDisable(true);
            player.setHealth(player.getHealth() + 50);
            player.setAttack(35);
            display();

        }
        if (name.equals("Final Boss")) {
            bigbossbtn.setDisable(true);
            WinScene scene = new WinScene(game);
            scene.setup();
        }

    }

    public void show() {
        display();
    }

}
