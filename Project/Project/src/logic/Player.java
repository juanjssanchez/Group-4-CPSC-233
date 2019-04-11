package logic;

public abstract class  Player {

    private int health;
    private int attack;

    Player() {
        this.health = 100;
        this.attack = 10;
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

    public abstract void decreaseHealth(int damage);

    public abstract int takeTurn();
}
