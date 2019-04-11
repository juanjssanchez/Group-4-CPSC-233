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
    Label eventDescription;


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
                this.eventDescription.setText("   EVENT DESCRIPTION:\n BOTH ATTACKED AT THE SAME TIME\n(NO DAMAGE TAKEN NOR GIVEN)");
            }
            if (enemyTurn == 1) { // enemy chose dodge
                this.eventDescription.setText("  Event Description:\nEnemy dodged your attack\n(No damage given)");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }
            if (enemyTurn == 2) { // enemy chose "read"
                this.eventDescription.setText("  Event Description:\nYou attack enemy" + "You did" + player.getAttack() + "damage");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\n\nHealth: " + enemy.getHealth());
            }

        } else if (source.getText().contains("Dodge")) {

            if (enemyTurn == 0) {
                this.eventDescription.setText("  Event Description:\n\"You dodged enemy attack");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\n\nHealth: " + enemy.getHealth());
            }
            if (enemyTurn == 1) {
                this.eventDescription.setText("  Event Description:\nBoth dodged");
            }
            if (enemyTurn == 2) {
                this.eventDescription.setText("  Event Description:\nEnemy counters dodge with magic");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }

        } else if (source.getText().contains("Magic")) {

            if (enemyTurn == 0) {;
                this.eventDescription.setText("  Event Description:\nEnemy attacks you");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }
            if (enemyTurn == 1) {
                this.eventDescription.setText("  Event Description:\nYou counter dodge with magic");
                enemy.decreaseHealth(player.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());
            }
            if (enemyTurn == 2) {
                this.eventDescription.setText("  Event Description:\nBoth use magic");
            }
        }
    }
}