package gui;

import drivers.Project;
import handlers.BackBtnHandler;
import handlers.BtnTurnHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import logic.Enemy;
import logic.Game;
import logic.Human;
import logic.Player;

public class BattleScene extends BaseScene {

    private int mhealth = 0; //enemy stats will be set by whichever button pressed in FirstScene
    private int mattack = 0;

    public BattleScene(Project game, int h, int a) {
        super(game);
        mhealth = h;
        mattack = a;
    }


    @Override
    public void setup() {
        //Setting up the backend
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefRows(2);

        //Initialize game
        Player enemy = new Enemy(mhealth, mattack);

        Player player = new Human();
        Game game = new Game(player);

        //Setting up the first row
        TilePane firstRow = new TilePane(Orientation.HORIZONTAL);
        firstRow.setPrefColumns(2);
        firstRow.setPrefHeight(250);
        firstRow.setPrefWidth(300);
        firstRow.setHgap(150);

        firstRow.getChildren().add(sceneA(game.getPlayer()));    //Setting up first scene (top left)
        firstRow.getChildren().add(sceneB(game.getPlayer()));    //Setting up second scene (top right)

        //Add first row to root
        root.getChildren().add(firstRow);

        root.setAlignment(Pos.CENTER);
        firstRow.setAlignment(Pos.CENTER);

        //Setting up the second row
        TilePane secondRow = new TilePane(Orientation.HORIZONTAL);
        secondRow.setPrefColumns(2);
        secondRow.setPrefHeight(250);
        secondRow.setPrefWidth(300);
        secondRow.setHgap(150);

        secondRow.getChildren().add(sceneC(enemy)); //Setting up third scene (bottom left)
        secondRow.getChildren().add(sceneD()); ////Setting up fourth scene (bottom right)

        secondRow.setAlignment(Pos.CENTER);

        root.getChildren().add(secondRow);

        Scene scene = new Scene(root, 600, 500);


        setScene(scene);
        display();

    }

    public Node sceneA(Player player) { //Player stats
        Group root = new Group();

        Label label = new Label("PLAYER:\n\nHealth: " + player.getHealth());

        root.getChildren().add(label);

        return root;
    }

    public Node sceneB(Player player) { //Combat buttons
        //Init buttons
        Button attack = new Button("Attack");
        Button dodge = new Button("Dodge");
        Button read = new Button("Read");
        Button back = new Button("Run Away");

        attack.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        dodge.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        read.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        back.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);

        //Add event handlers
        BtnTurnHandler handler = new BtnTurnHandler(player);
        attack.setOnAction(handler);
        dodge.setOnAction(handler);
        read.setOnAction(handler);

        BackBtnHandler bHandler = new BackBtnHandler(getGame());
        back.setOnAction(bHandler);


        //Setup vbox
        VBox box = new VBox();
        box.setSpacing(10.0);
        box.getChildren().addAll(attack, dodge, read, back);
        box.setAlignment(Pos.CENTER);

        return box;
    }

    public Node sceneC(Player enemy) {   // Enemy Stats
        Group root = new Group();

        Label label = new Label("ENEMY:\n\nHealth: " + enemy.getHealth());

        root.getChildren().add(label);

        return root;
    }

    public Node sceneD() {  //event description ("attacked for 10 damage", "enemy blocked the attack")
        HBox box = new HBox();
        Label label = new Label("  Event\n\nDescription");
        box.getChildren().add(label);
        box.setAlignment(Pos.CENTER);


        return box;
    }


}
