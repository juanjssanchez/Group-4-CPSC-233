package logic;

import drivers.Project;
import gui.FirstScene;

import java.util.Random;

public class Enemy extends Player{

    Project project;
	int mhealth = 0;
	int mattack = 0;
	private String name; 
	
	private FirstScene firstScene;

    public Enemy(Project game, int health, int attack, FirstScene fs, String name){
        super(health, attack);
        this.project = game;
        firstScene = fs;
        this.name = name;
    }

    public void decreaseHealth(int damage){
        if (damage >= this.getHealth()){
            System.out.println("monster dead\nYou won that battle!");
            firstScene.updateScene(name);
        } else{
            this.setHealth(this.getHealth() - damage);
        }
    }

    public int takeTurn(){
        Random r = new Random();
        return r.nextInt(3);    // random number represents enemy's combat option
    }

}
