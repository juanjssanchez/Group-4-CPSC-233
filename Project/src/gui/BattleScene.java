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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.Enemy;
import logic.Game;
import logic.Player;

public class BattleScene extends BaseScene {

    private int mhealth = 0; //enemy stats will be set by whichever button pressed in FirstScene
    private int mattack = 0;
    private Label eventDescription;
    private Label playerHealth;
    private Label enemyHealth;
    private FirstScene firstScene;
    private String monsterName;
    private Player player;

    public BattleScene(Project game, int h, int a, FirstScene fs, String monsterName, Player player) {
        super(game);
        mhealth = h;
        mattack = a;
        firstScene = fs;
        this.monsterName = monsterName;
        this.player = player;
    }


    @Override
    public void setup() {
        //Setting up the backend
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefRows(2);

        //Initialize game
        Enemy enemy = new Enemy(getGame(), mhealth, mattack, firstScene, monsterName);

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

        //background image
        BackgroundImage myBI= new BackgroundImage(new Image("file:img/backgroundbattle.gif",600,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //then you set to your node
        root.setBackground(new Background(myBI));


        Scene scene = new Scene(root, 600, 500);


        setScene(scene);
        display();

    }

    public Node sceneA(Player player) { //Player stats
        Group root = new Group();

        playerHealth = new Label();

        root.getChildren().add(playerHealth);playerHealth = new Label("PLAYER:\n\nHEALTH: " + player.getHealth());
        playerHealth.setTextFill(Color.INDIGO);
        playerHealth.setStyle("-fx-font: 12 arial;");
        root.getChildren().add(playerHealth);

        return root;
    }

    public Node sceneB(Player player, Player enemy) { //Combat buttons
        //Init buttons
        Button attack = new Button("Attack");
        Button dodge = new Button("Dodge");
        Button magic = new Button("Magic");
        Button back = new Button("Run Away");

        //button images
        Image attackimg = new Image("file:img/attack.gif",30,30,false,false);
        attack.setGraphic(new ImageView(attackimg));
        Image dodgeimg = new Image("file:img/monster1.gif",30,30,false,false);
        dodge.setGraphic(new ImageView(dodgeimg));
        Image magicimg = new Image("file:img/monster2.gif",30,30,false,false);
        magic.setGraphic(new ImageView(magicimg));
        Image backimg = new Image("file:img/run.gif",30,30,false,false);
        back.setGraphic(new ImageView(backimg));

        attack.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        dodge.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        magic.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);
        back.setPrefSize(BtnConfig.btnW, BtnConfig.btnH);

        //Add event handlers
        BtnTurnHandler handler = new BtnTurnHandler(player, enemy, playerHealth, enemyHealth, eventDescription);
        attack.setOnAction(handler);
        dodge.setOnAction(handler);
        magic.setOnAction(handler);

        BackBtnHandler bHandler = new BackBtnHandler(getGame(), firstScene);
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

        enemyHealth = new Label("ENEMY:\n\nHEALTH: " + enemy.getHealth());
        enemyHealth.setTextFill(Color.RED);
        enemyHealth.setStyle("-fx-font: 12 arial;");
        root.getChildren().add(enemyHealth);

        return root;
    }

    public Node sceneD() {  //event description ("attacked for 10 damage", "enemy blocked the attack")
        HBox box = new HBox();
        eventDescription = new Label("  EVENT DESCRIPTION:\n");
        eventDescription.setTextFill(Color.INDIGO);
        eventDescription.setStyle("-fx-font: 12 Courier;");

        box.getChildren().add(eventDescription);
        box.setAlignment(Pos.CENTER);

        return box;
    }


}
