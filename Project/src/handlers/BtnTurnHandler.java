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
        if (source.getText().contains("Potion")) {
        	this.eventDescription.setText("   \n\n\nEvent Description:\nYou healed 50 Health!");
        	//player.setHealth( health + 50);
        }
        if (source.getText().contains("Attack")) {

            if (enemyTurn == 0) { // enemy chose attack
                this.eventDescription.setText("  \n\n\nEvent Description:\nBoth Attacked\nNothing Happened.");
            }
            if (enemyTurn == 1) { // enemy chose dodge
                this.eventDescription.setText("  \n\n\nEvent Description:\nEnemy dodged your attack\n" + "You took " + enemy.getAttack()+ " damage!");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHEALTH: " + player.getHealth());
            }
            if (enemyTurn == 2) { // enemy chose "read"
                this.eventDescription.setText("  \n\n\nEvent Description:\nYou attack enemy\n" + "You did " + player.getAttack() + " damage!");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\n\nHEALTH: " + enemy.getHealth());
            }

        } else if (source.getText().contains("Dodge")) {

            if (enemyTurn == 0) {
                this.eventDescription.setText("  \n\n\nEvent Description:\nYou dodged enemy attack\n"+ "You did " + player.getAttack()+ " damage!");
                enemy.decreaseHealth(player.getAttack());
                this.enemyHealth.setText("ENEMY:\n\nHEALTH: " + enemy.getHealth());
                
            }
            if (enemyTurn == 1) {
                this.eventDescription.setText("  \n\n\nEvent Description:\nBoth dodged\nNothing Happened.");
            }
            if (enemyTurn == 2) {
                this.eventDescription.setText("  \n\n\nEvent Description:\nEnemy counters dodge with magic\n" +"You took " + enemy.getAttack()+ " damage!");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHEALTH: " + player.getHealth());
            }

        } else if (source.getText().contains("Magic")) {

            if (enemyTurn == 0) {;
                this.eventDescription.setText("  \n\n\nEvent Description:\nEnemy attacks you\n"+ "You took " + enemy.getAttack()+ " damage!");
                player.decreaseHealth(enemy.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHEALTH: " + player.getHealth());
            }
            if (enemyTurn == 1) {
                this.eventDescription.setText("  \n\n\nEvent Description:\nYou counter dodge with magic\n" + "You did " + player.getAttack() + " damage!");
                enemy.decreaseHealth(player.getAttack());
                this.playerHealth.setText("PLAYER:\n\nHEALTH: " + player.getHealth());
            }
            if (enemyTurn == 2) {
                this.eventDescription.setText("  \n\n\nEvent Description:\nBoth use magic\nNothing Happened.");
            }
        }
    }
}