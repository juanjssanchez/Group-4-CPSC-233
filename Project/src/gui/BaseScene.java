package gui;

import drivers.Project;
import javafx.scene.Scene;

public abstract class BaseScene {
	protected Scene scene;
    protected Project game;

    BaseScene(Project game) {
        this.game = game;
    }

    void setScene(Scene scene) {
        this.scene = scene;
    }

    Project getGame() {
        return game;
    }

    public abstract void setup();

    void display() {
        game.setScene(this.scene);
    }
}