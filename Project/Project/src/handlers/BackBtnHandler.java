package handlers;

import drivers.Project;
import gui.FirstScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BackBtnHandler implements EventHandler<ActionEvent> {

    Project project;

    public BackBtnHandler(Project project){
        this.project = project;
    }

    @Override
    public void handle(ActionEvent event) {

        FirstScene scene = new FirstScene(project);
        scene.setup();
    }
}
