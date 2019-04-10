package handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.Player;

public class BtnTurnHandler implements EventHandler<ActionEvent> {
    Player player;
    Player enemy;
    Label playerHealth;
    Label enemyHealth;


    public BtnTurnHandler(Player player, Player enemy, Label playerHealth, Label enemyHealth) {
        this.player = player;
        this.enemy = enemy;
        this.playerHealth = playerHealth;
        this.enemyHealth = enemyHealth;
    }

    @Override
    public void handle(ActionEvent event) {

        Button source = (Button) event.getSource();
        int enemyTurn = enemy.takeTurn();   //enemy's random combat option represented by an integer

        if (source.getText().contains("Attack")) {

            if (enemyTurn == 0) { // enemy chose attack
                System.out.println("Both attacked at same time");      //PRINT STATEMENTS SHOULD INSTEAD BE SHOWN IN GUI
            }
            if (enemyTurn == 1) { // enemy chose dodge
                System.out.println("Enemy dodged your attack");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }
            if (enemyTurn == 2) { // enemy chose "read"
                System.out.println("You attack enemy");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\n\nHealth: " + enemy.getHealth());
            }

        } else if (source.getText().contains("Dodge")) {

            if (enemyTurn == 0) {
                System.out.println("You dodged enemy attack");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\n\nHealth: " + enemy.getHealth());
            }
            if (enemyTurn == 1) {
                System.out.println("Both dodged");
            }
            if (enemyTurn == 2) {
                System.out.println("Enemy counters dodge with magic");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }

        } else if (source.getText().contains("Magic")) {

            if (enemyTurn == 0) {
                System.out.println("Enemy attacks you");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }
            if (enemyTurn == 1) {
                System.out.println("You counter dodge with magic");
                enemy.decreaseHealth(player.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }
            if (enemyTurn == 2) {
                System.out.println("Both use magic");
            }
        }
    }
}
