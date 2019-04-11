package handlers;

import drivers.Project;
import gui.BattleScene;
import gui.FirstScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import logic.Player;

public class MonsterBtnHandler implements EventHandler<ActionEvent> {

	Project project;
	FirstScene firstScene;
	Player player;

	public MonsterBtnHandler(Project project, FirstScene fs, Player player){
		this.project = project;
		firstScene = fs;
		this.player = player;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source = (Button) event.getSource();
		String MonsterName = new String();
		int mhealth = 0;
		int mattack = 0;

		if (source.getText().contains("Monster 1")){
			mhealth = 50;
			mattack = 10;
			MonsterName = "Monster 1";
		} else if (source.getText().contains("Monster 2")){
			mhealth = 75;
			mattack = 15;
			MonsterName = "Monster 2";
		} else if (source.getText().contains("Monster 3")){
			mhealth = 100;
			mattack = 20;
			MonsterName = "Monster 3";
		} else if (source.getText().contains("Final Boss")){
			mhealth = 200;
			mattack = 50;
			MonsterName = "Final Boss";
		}

		BattleScene scene = new BattleScene(project, mhealth, mattack, firstScene, MonsterName, player);
		scene.setup();
	}
	

}
