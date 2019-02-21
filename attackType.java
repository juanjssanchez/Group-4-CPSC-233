public enum attackType{

	slap(1)
	punch(5),
	kick(7);


	private int damage;

    private attackType randomAttack(){
    int pick = new Random().nextInt(attackType.values().length);
    return attackType.values()[pick];
    }

}
