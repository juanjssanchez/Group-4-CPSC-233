public enum attackType{

	slap(1)
	punch(5),
	kick(7);


	private int damage;


	attackType(int damageAmount){
	damage = damageAmount;
	}
	
	public int getDamage(){
		return damage;
	}

}
