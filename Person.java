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
	public int decreaseHealth(){
		return health;
	}

	public int increaseHealth(){
		return health;
	}

	public boolean aliveOrDead(){
		return false;
	}
}
