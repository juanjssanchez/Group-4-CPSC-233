package handlers;

import gui.FirstScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BackBtnHandler implements EventHandler<ActionEvent> {

    private FirstScene firstScene;

    public BackBtnHandler(FirstScene fs){
        firstScene = fs;
    }

    @Override
    public void handle(ActionEvent event) {
    	firstScene.show();
    }
}
