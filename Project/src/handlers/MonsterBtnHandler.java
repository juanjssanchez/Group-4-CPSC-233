package handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("cd ../../stats/monster1stats.txt"));
				mhealth = Integer.parseInt(reader.readLine());
				mattack = Integer.parseInt(reader.readLine());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			MonsterName = "Monster 1";
		} else if (source.getText().contains("Monster 2")){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("cd ../../stats/monster2stats.txt"));
				mhealth = Integer.parseInt(reader.readLine());
				mattack = Integer.parseInt(reader.readLine());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			MonsterName = "Monster 2";
		} else if (source.getText().contains("Monster 3")){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("cd ../../stats/monster3stats.txt"));
				mhealth = Integer.parseInt(reader.readLine());
				mattack = Integer.parseInt(reader.readLine());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			MonsterName = "Monster 3";
		} else if (source.getText().contains("Final Boss")){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("cd ../../stats/finalBossStats.txt"));
				mhealth = Integer.parseInt(reader.readLine());
				mattack = Integer.parseInt(reader.readLine());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			MonsterName = "Final Boss";
		}

		BattleScene scene = new BattleScene(project, mhealth, mattack, firstScene, MonsterName, player);
		scene.setup();
	}
	

}
