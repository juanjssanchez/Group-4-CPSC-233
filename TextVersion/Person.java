public class Person extends Main{

/*Enemy is a class that represents enemies the player/avatar must battle when encountered on the map.  
-The enemy should have a health
-and a method that indicates how to attack during each turn/round.
-You may also need a boolean method that indicates if the Enemy is alive or dead.*/


	private int health;
	private int attackDamage;
	private Player player;

	Person(){
		health = 100;
		attackDamage = 50;
	}

	Person(int initialHealth, int initialDamage){
		health = initialHealth;
		attackDamage = initialDamage;
	}

	Person(Player p){
		health = 100;
		attackDamage = 50;
		player = p;
	}


	public int getHealth(){
		return health;
	}

	public int getAttackDamage(){
		return attackDamage;
	}

	public void setHealth(int h){
		health = h;
	}

	public void setAttackDamage(int d){
		attackDamage = d;
	}


	public void decreaseHealth(int damageAmount){
		health -= damageAmount;
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