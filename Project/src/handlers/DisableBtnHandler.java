package handlers;

import drivers.Project;
import gui.BattleScene;
import gui.FirstScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
public class DisableBtnHandler implements EventHandler<ActionEvent> {
	Project project;
	public DisableBtnHandler(Project project){
		this.project = project;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source = (Button) event.getSource();
		int mhealth = 0;
		int mattack = 0;

		if (source.getText().contains("Monster 1")){
			//m1btn.setDisable(true);
		} else if (source.getText().contains("Monster 2")){
			mhealth = 75;
			mattack = 15;
		} else if (source.getText().contains("Monster 3")){
			mhealth = 100;
			mattack = 20;
		} else if (source.getText().contains("Final Boss")){
			mhealth = 200;
			mattack = 50;
		}

		FirstScene scene = new FirstScene(project);
		scene.setup();
	}

}
