public class Player extends Person{
    private int health;
    private ArrayLlist<Collecible> items;
    private Location location;
 
    int potion = 30;
    int maxPlayerDamage = 30;
    public Direction getDirection{
        return;
    }
    public AttackType getMove(enemy:Enemy){
        return;
    }

    public int getHealth(){
        return health;
    }
    public void usePotion(){
        health += potion;
    }
    public void buff(){
        maxPlayerDamage+=5;
    }
}
