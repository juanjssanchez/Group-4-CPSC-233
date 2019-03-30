package gui;
import drivers.Project;
import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;
public class BattleScene extends BaseScene{

	public BattleScene(Project game) {
		super(game);
	}

	@Override
	public void setup() {
		TilePane root = new TilePane(Orientation.VERTICAL);
		root.setPrefRows(2);
		
		TilePane firstRows = new TilePane(Orientation.HORIZONTAL);
		firstRow.setPrefColumns(2);
		firstRow.setPrefHeight(250);
		
	}
	

}
