package gui;

import drivers.Project;
import javafx.scene.Scene;

public abstract class BaseScene {
    private Scene scene;
    private Project game;

    public BaseScene(Project game) {
        this.game = game;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Project getGame() {
        return game;
    }

    public void setGame(Project game) {
        this.game = game;
    }


    public abstract void setup();

    protected void display() {
        game.setScene(this.scene);
    }
}
