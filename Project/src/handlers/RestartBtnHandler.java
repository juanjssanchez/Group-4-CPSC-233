package handlers;

import drivers.Project;
import gui.FirstScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RestartBtnHandler implements EventHandler<ActionEvent> {

    Project project;

    public RestartBtnHandler(Project project){
        this.project = project;
    }

    @Override
    public void handle(ActionEvent event) {

        FirstScene scene = new FirstScene(project);
        scene.setup();
    }
}
