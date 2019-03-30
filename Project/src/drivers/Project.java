package drivers;
import gui.FirstScene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class Project extends Application{
	Stage stage;
	public void setScene(Scene scene) {
		stage.setScene(scene);
	}
	
	public void start(Stage stage) {
		this.stage = stage;
		stage.setTitle("Group 4 final project");
		stage.show();
		FirstScene scene = new FirstScene(this);
		scene.setup();
	}
	
	public static void main (String[] args) {
		launch(args);
		
	}
}
