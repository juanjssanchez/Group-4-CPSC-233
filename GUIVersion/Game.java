import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;

/*The Game class has all of the classes combined and will eventually be split up into its
own classes, eg. Enemy class, battle screen class, map class. This Demo is just to show
the main look/feel of the game.*/

public class Game extends Application{

    Stage window;
    Scene scene, scene2;
    Node playerImage;
    Node enemyImage;
    boolean goUp, goDown, goLeft, goRight;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Group root = new Group();
        window = stage;

        Person player = new Person(100, 50, new Image("guy.png"));
        Person enemy = new Person(100, 25, new Image("creeper.png"));

        Image background = new Image("background.png");     /*import background, character, enemy, and background images*/
        ImageView b = new ImageView(background);
        b.setFitHeight(400);
        b.setFitWidth(600);
        root.getChildren().add(b);

        //sets character near the middle
        Image myIcon = player.getImage();
        ImageView icon = new ImageView(myIcon);
        playerImage = icon;
        playerImage.relocate(300, 200);
        root.getChildren().add(playerImage);

        //sets monster
        Image myCreeper = enemy.getImage();
        ImageView creeper = new ImageView(myCreeper);
        enemyImage = creeper;
        enemyImage.relocate(400, 100);
        root.getChildren().add(enemyImage);

        //sets background as plain white
        Scene scene = new Scene(root, 600, 400, Color.WHITE);
        stage.setScene(scene);
        stage.show();

        Group root2 = new Group();                      /* GUI for the battle component of the game, will later on be moved into Battle class*/

        Image backg = new Image("background2.png");     //second background//
        ImageView ba = new ImageView(backg);
        ba.setFitHeight(400);
        ba.setFitWidth(600);
        root2.getChildren().add(ba);

        Button btnAttack;
        Button btnDefend;
        Button btnItem;
        Button btnRun;

        btnAttack = new Button("Attack");
        btnAttack.setLayoutX(50);
        btnAttack.setLayoutY(300);
        btnDefend = new Button("Defend");
        btnDefend.setLayoutX(170);
        btnDefend.setLayoutY(300);
        btnItem = new Button("Use Item");
        btnItem.setLayoutX(290);
        btnItem.setLayoutY(300);
        btnRun = new Button("Run");
        btnRun.setLayoutX(430);
        btnRun.setLayoutY(300);

        Image imgAttack = new Image("Attack.png");
        btnAttack.setGraphic(new ImageView(imgAttack));
        Image imgDefend = new Image("Defend.png");
        btnDefend.setGraphic(new ImageView(imgDefend));
        Image imgItem = new Image("Item.png");
        btnItem.setGraphic(new ImageView(imgItem));
        Image imgRun = new Image("Run.png");
        btnRun.setGraphic(new ImageView(imgRun));

        btnAttack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                enemy.decreaseHealth(player.getAttackDamage());
                System.out.println("You hit monster for " + enemy.getHealth());
                if(!enemy.alive()){
                    creeper.setImage(null);
                    stage.setScene(scene);
                    System.out.println("You captured the monster");
                }
            }
        });
        btnDefend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("You defend yourself");
            }
        });
        btnItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                player.increaseHealth(20);
                System.out.println("You heal yourself");
            }
        });
        //btnRun.setOnAction(e -> stage.setScene(scene));
        btnRun.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(scene);
                System.out.println("You ran away");
            }
        });

        root2.getChildren().add(btnAttack);
        root2.getChildren().add(btnDefend);
        root2.getChildren().add(btnItem);
        root2.getChildren().add(btnRun);

        scene2 = new Scene(root2, 600, 400, Color.WHITE);
        Image guy = new Image("guy.png");               //character image//
        ImageView myGuy = new ImageView(guy);
        myGuy.setFitHeight(50);
        myGuy.setFitWidth(50);
        myGuy.relocate(100, 150);
        root2.getChildren().add(myGuy);

        Image creepImage = new Image("creeper.png");        //enemy image//
        ImageView myCreepy = new ImageView(creepImage);
        myCreepy.setFitHeight(50);
        myCreepy.setFitWidth(50);
        myCreepy.relocate(400, 150);
        root2.getChildren().add(myCreepy);


        /*this first section reads the keypress of an arrow key, takes user input to move character around*/
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event){
                switch (event.getCode()){
                    case UP: goUp = true;break;
                    case DOWN: goDown = true;break;
                    case LEFT: goLeft = true;break;
                    case RIGHT: goRight = true;break;
                }
            }
        });
        // this second section checks when the key pressed above is released
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event){
                switch (event.getCode()){
                    case UP: goUp = false;break;
                    case DOWN: goDown = false;break;
                    case LEFT: goLeft = false;break;
                    case RIGHT: goRight = false;break;
                }
            }
        });
        //updates the image of the character as it moves around the screen, changing positions
        AnimationTimer timer = new AnimationTimer(){
            double delta = 4;
            @Override
            public void handle(long arg0){
                double currX = playerImage.getLayoutX();
                double currY = playerImage.getLayoutY();

                if(goUp && currY > 0.0) currY -= delta;
                if(goDown && currY < 350) currY += delta;
                if(goLeft && currX > 0.0) currX -= delta;
                if(goRight && currX < 555) currX += delta;
                playerImage.relocate(currX, currY);

                //if in range of monster, switches to scene 2
                if (enemy.alive()) {
                    if (enemyImage.getLayoutX() - 50 <= currX && currX < enemyImage.getLayoutX() + 50 && enemyImage.getLayoutY() - 50 <=
                            currY && currY < enemyImage.getLayoutY() + 50) {
                        window.setScene(scene2); // scene 2
                    }
                }
            }
        };
        timer.start();
    }
}