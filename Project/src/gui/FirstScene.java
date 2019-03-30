package gui;
import drivers.Project;
import handlers.QuitBtnHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class FirstScene extends BaseScene {

	public FirstScene(Project game) {
		super(game);
	} 

	@Override
	public void setup() {
		//Create buttons//
		Button quitbtn = new Button("Quit");
		Button m1btn= new Button("Monster 1");		//Monster buttons//
		Button m2btn= new Button("Monster 2");
		Button m3btn = new Button("Monster 3");
		Button bigbossbtn = new Button("Final Boss");
		
		//Images for the buttons//
		Image quitImg = new Image("file:img/Run.png");	
		quitbtn.setGraphic(new ImageView(quitImg));
		Image enem1Img = new Image("file:img/enemy1.png");	
		m1btn.setGraphic(new ImageView(enem1Img));
		Image enem2Img = new Image("file:img/enemy2.png");	
		m2btn.setGraphic(new ImageView(enem2Img));
		
		//Add buttons to HBox//
		HBox box = new HBox();
		box.getChildren().add(quitbtn);
		box.getChildren().add(m1btn);
		box.getChildren().add(m2btn);
		box.getChildren().add(m3btn);
		box.getChildren().add(bigbossbtn);
		box.setAlignment(Pos.CENTER);	 	//Move buttons to middle//
		
		//Add Hbox to pane//
		StackPane pane = new StackPane();
		pane.getChildren().add(box);
		pane.setAlignment(Pos.CENTER);
		
		//Attach event handlers to buttons//
		QuitBtnHandler qHandler = new QuitBtnHandler();
		quitbtn.setOnAction(qHandler);
		
		
		//Set Scene//
		setScene(new Scene(pane,600,500));
		display();
	}
	
}
