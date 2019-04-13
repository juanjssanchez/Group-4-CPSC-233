package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class  Player {

    private int health;
    private int attack;

    Player() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("cd ../../stats/playerStats.txt"));
			this.health = Integer.parseInt(reader.readLine());
			this.attack = Integer.parseInt(reader.readLine());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }

    Player(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public abstract void decreaseHealth(int damage);

    public abstract int takeTurn();
    
    
}
