public class Player extends Person{

    private int potions;
    private int captives;

    Player(int initialHealth, int initialDamage){
        super(initialHealth, initialDamage);
        potions = 3;
    }

    public int getNumPotions(){
        return potions;
    }

    public void addPotion(){
        potions++;
    }

    public void usePotion(){
        this.increaseHealth(30);
        potions = potions - 1;
    }

    public int getNumCaptives(){
        return captives;
    }

    public void addCaptive(){
        captives++;
    }


}
