package handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.Player;

public class BtnTurnHandler implements EventHandler<ActionEvent> {
    private Player player;
    private Player enemy;
    private Label playerHealth;
    private Label enemyHealth;
    private Label eventDescription;


    public BtnTurnHandler(Player player, Player enemy, Label playerHealth, Label enemyHealth, Label eventDescription) {
        this.player = player;
        this.enemy = enemy;
        this.playerHealth = playerHealth;
        this.enemyHealth = enemyHealth;
        this.eventDescription = eventDescription;
    }

    @Override
    public void handle(ActionEvent event) {

        Button source = (Button) event.getSource();
        int enemyTurn = enemy.takeTurn();   //enemy's random combat option represented by an integer

        if (source.getText().contains("Attack")) {

            if (enemyTurn == 0) { // enemy chose attack
                this.eventDescription.setText("Event Description:\n Both attacked\n at same time");
            }
            if (enemyTurn == 1) { // enemy chose dodge
                this.eventDescription.setText("Event Description:\nEnemy dodged\n your attack -" + enemy.getAttack());
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\nHealth: " + player.getHealth() + "\nAttack " + player.getAttack());
            }
            if (enemyTurn == 2) { // enemy chose "read"
                this.eventDescription.setText("Event Description:\nYou attack enemy\n" + "You did " + player.getAttack() + " damage");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\nHealth: " + enemy.getHealth() + "\nAttack " + enemy.getAttack());
            }

        } else if (source.getText().contains("Dodge")) {

            if (enemyTurn == 0) {
                this.eventDescription.setText("  Event Description:\nYou dodged enemy\n You did " + player.getAttack() + " damage");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\nHealth: " + enemy.getHealth() + "\nAttack " + enemy.getAttack());
            }
            if (enemyTurn == 1) {
                this.eventDescription.setText("Event Description:\nBoth dodged");
            }
            if (enemyTurn == 2) {
                this.eventDescription.setText("Event Description:\nEnemy counters\ndodge with magic\n       -" + enemy.getAttack());
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\nHealth: " + player.getHealth() + "\nAttack " + player.getAttack());
            }

        } else if (source.getText().contains("Magic")) {

            if (enemyTurn == 0) {
                this.eventDescription.setText("Event Description:\nEnemy attacks you\n      -" + enemy.getAttack());
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\nHealth: " + player.getHealth() + "\nAttack " + player.getAttack());
            }
            if (enemyTurn == 1) {
                this.eventDescription.setText("Event Description:\nYou counter dodge\n    with magic\n You did " + player.getAttack() + " damage");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\nHealth: " + enemy.getHealth() + "\nAttack " + enemy.getAttack());
            }
            if (enemyTurn == 2) {
                this.eventDescription.setText("Event Description:\nBoth use magic");
            }
        }
    }
}