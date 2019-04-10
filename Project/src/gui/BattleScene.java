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
    private Label playerHealth;
    private Label enemyHealth;

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
        Player enemy = new Enemy(getGame(), mhealth, mattack);

        Player player = new Human(getGame());
        Game game = new Game(player);


        //Setting up the first row
        TilePane rowOne = new TilePane(Orientation.HORIZONTAL);
        rowOne.setPrefColumns(2);
        rowOne.setPrefHeight(250);
        rowOne.setPrefWidth(300);
        rowOne.setHgap(150);

        rowOne.getChildren().add(sceneA(game.getPlayer()));    //Setting up first scene (top left)
        rowOne.getChildren().add(sceneD()); ////Setting up fourth scene (bottom right)

        rowOne.setAlignment(Pos.CENTER);

        root.getChildren().add(rowOne);

        //Setting up the second row
        TilePane rowTwo = new TilePane(Orientation.HORIZONTAL);
        rowTwo.setPrefColumns(2);
        rowTwo.setPrefHeight(250);
        rowTwo.setPrefWidth(300);
        rowTwo.setHgap(150);

        rowTwo.getChildren().add(sceneC(enemy)); //Setting up third scene (bottom left)
        rowTwo.getChildren().add(sceneB(game.getPlayer(), enemy));    //Setting up second scene (top right)

        root.getChildren().add(rowTwo);

        root.setAlignment(Pos.CENTER);
        rowTwo.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 500);


        setScene(scene);
        display();

    }

    public Node sceneA(Player player) { //Player stats
        Group root = new Group();

        playerHealth = new Label("PLAYER:\n\nHealth: " + player.getHealth());

        root.getChildren().add(playerHealth);

        return root;
    }

    public Node sceneB(Player player, Player enemy) { //Combat buttons
        //Init buttons
        Button attack = new Button("Attack");
        Button dodge = new Button("Dodge");
        Button magic = new Button("Magic");
        Button back = new Button("Run Away");

        attack.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        dodge.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        magic.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        back.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);

        //Add event handlers
        BtnTurnHandler handler = new BtnTurnHandler(player, enemy, playerHealth, enemyHealth);
        attack.setOnAction(handler);
        dodge.setOnAction(handler);
        magic.setOnAction(handler);

        BackBtnHandler bHandler = new BackBtnHandler(getGame());
        back.setOnAction(bHandler);


        //Setup vbox
        VBox box = new VBox();
        box.setSpacing(10.0);
        box.getChildren().addAll(attack, dodge, magic, back);
        box.setAlignment(Pos.CENTER);

        return box;
    }

    public Node sceneC(Player enemy) {   // Enemy Stats
        Group root = new Group();

        enemyHealth = new Label("ENEMY:\n\nHealth: " + enemy.getHealth());

        root.getChildren().add(enemyHealth);

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
