package logic;

import drivers.Project;
import gui.FirstScene;

import java.util.Random;

public class Enemy extends Player{

    Project project;

    public Enemy(Project game, int health, int attack){
        super(health, attack);
        this.project = game;
    }

    public void decreaseHealth(int damage){
        if (damage >= this.getHealth()){
            System.out.println("monster dead\nYou won that battle");
            FirstScene scene = new FirstScene(project);
            scene.setup();
        } else{
            this.setHealth(this.getHealth() - damage);
        }
    }

    public int takeTurn(){
        Random r = new Random();
        return r.nextInt(3);    // random number represents enemy's combat option
    }
}
