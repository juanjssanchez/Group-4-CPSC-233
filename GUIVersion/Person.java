import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Person {

/*Enemy is a class that represents enemies the player/avatar must battle when encountered on the map.
-The enemy should have a health
-and a method that indicates how to attack during each turn/round.
-You may also need a boolean method that indicates if the Enemy is alive or dead.*/

	private int health;
	private int attackDamage;
	private Image image;

	Person(int initialHealth, int initialDamage, Image i){
		health = initialHealth;
		attackDamage = initialDamage;
		image = i;
	}


	//getter methods//

	public int getHealth(){
		return health;
	}

	public int getAttackDamage(){
		return attackDamage;
	}

	public Image getImage(){
		return image;
	}

	//setters
	public void setHealth(int h){
		health = h;
	}

	public void setAttackDamage(int d){
		attackDamage = d;
	}


	public void decreaseHealth(int damageAmount) {
		if(damageAmount <= health) {
			health -= damageAmount;
		}
	}

	public void increaseHealth(int healAmount){
		health += healAmount;
	}

	public boolean alive(){
		if (health > 0){
			return true;
		}
		else {
			return false;
		}
	}
}