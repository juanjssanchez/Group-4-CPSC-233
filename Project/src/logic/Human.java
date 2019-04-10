package logic;

import drivers.Project;
import gui.GameOverScene;

public class Human extends Player{

    Project project;

    public Human(Project game){
        super();
        this.project = game;
    }

    public void decreaseHealth(int damage){
        if (damage >= this.getHealth()){
            GameOverScene scene = new GameOverScene(project);
            scene.setup();
        } else{
            this.setHealth(this.getHealth() - damage);
        }
    }

    public void takeTurn() {
        //do something
    }
}
