package logic;

public class Enemy extends Player{

    public Enemy(int health, int attack){
        super(health, attack);
    }

    public void decreaseHealth(int damage){
        if (damage >= this.getHealth()){
            System.out.println("monster dead");
        } else{
            this.setHealth(this.getHealth() - damage);
        }
    }

    public void takeTurn(){
        //do something
    }
}
