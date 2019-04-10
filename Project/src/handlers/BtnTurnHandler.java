package handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.Player;

public class BtnTurnHandler implements EventHandler<ActionEvent> {
    Player player;
    Label playerHealth;

    public BtnTurnHandler(Player player, Label playerHealth){
        this.player = player;
        this.playerHealth = playerHealth;
    }

    @Override
    public void handle(ActionEvent event){ //
        Button source = (Button) event.getSource();

        if (source.getText().contains("Attack")){                       // buttons currently used for testing health changes
            player.decreaseHealth(10);                          //takes 10 damage at a time
            System.out.println("Player attacks " + player.getHealth());
            this.playerHealth.setText("PLAYER:\n\nHealth: " + player.getHealth());

        } else if (source.getText().contains("Dodge")){
            player.decreaseHealth(100);             //instant death

        } else if (source.getText().contains("Read")){
            // do something
        }
    }
}
