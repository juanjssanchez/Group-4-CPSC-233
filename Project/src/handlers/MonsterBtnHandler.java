package handlers;

import drivers.Project;
import gui.BattleScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MonsterBtnHandler implements EventHandler<ActionEvent> {

	Project project;

	public MonsterBtnHandler(Project project){
		this.project = project;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source = (Button) event.getSource();
		int mhealth = 0;
		int mattack = 0;

		if (source.getText().contains("Monster 1(Easy)")){
			mhealth = 50;
			mattack = 10;
		} else if (source.getText().contains("Monster 2(Normal)")){
			mhealth = 75;
			mattack = 15;
		} else if (source.getText().contains("Monster 3(Hard)")){
			mhealth = 100;
			mattack = 20;
		} else if (source.getText().contains("Final Boss")){
			mhealth = 200;
			mattack = 50;
		}

		BattleScene scene = new BattleScene(project, mhealth, mattack);
		scene.setup();
	}

}
