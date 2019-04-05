package logic;

public abstract class Player {

    private int health;
    private int attack;

    Player() {
        this.health = 100;
        this.attack = 20;
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

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void decreaseHealth() { //decreases by 1
        health = health - 10;
    }

    public abstract void takeTurn();
}
