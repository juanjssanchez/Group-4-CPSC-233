package handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import logic.Player;

public class BtnTurnHandler implements EventHandler<ActionEvent> {
    Player player;

    public BtnTurnHandler(Player player){
        this.player = player;
    }

    @Override
    public void handle(ActionEvent event){
        Button source = (Button) event.getSource();

        if (source.getText().contains("Attack")){
            //player.attack();
            System.out.println("Player attacks " + player.getHealth());
            player.decreaseHealth();
        } else if (source.getText().contains("Dodge")){
            System.out.println("Player dodges " + player.getHealth());

        } else if (source.getText().contains("Read")){
            System.out.println("Player reads opponent's attack " + player.getHealth());
        }
    }
}
