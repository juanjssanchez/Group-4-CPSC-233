package handlers;

import drivers.Project;
import gui.FirstScene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BackBtnHandler implements EventHandler<ActionEvent> {

    Project project;
    FirstScene firstScene;

    public BackBtnHandler(Project project, FirstScene fs){
        this.project = project;
        firstScene = fs;
    }

    @Override
    public void handle(ActionEvent event) {
    	firstScene.show();
    }
}
