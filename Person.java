public class Person {

/*Enemy is a class that represents enemies the player/avatar must battle when encountered on the map.  
-The enemy should have a health

-and a method that indicates how to attack during each turn/round.

-You may also need a boolean method that indicates if the Enemy is alive or dead.*/


	private int health;
	private Location location;


	//getter methods//
	public attackType getMove(){
		return attackType.punch;
	}

	public int getHealth(){
		return health;	
	}

	public Location getLocation(){
		return location
	}


	//setter methods
	


	//other methods
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
