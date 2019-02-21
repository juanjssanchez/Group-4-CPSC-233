import java.util.Scanner;
import java.util.Random;

/* *** Extremely rough draft of how the text based game might work ***
     -this is just a starting point/example to work from
     -still need to incorporate the other classes to work with this */


class TextApp {
    public static void main(String[] args){

        /*    The maps could look something like this i guess ??

        System.out.println( " _____________________\n" +
                            "|                     |\n" +
                            "|   *SCARY MONSTER*   |\n" +
                            "|        @here        |\n" +
                            "|                     |\n" +
                            "|                     |\n" +
                            "|                     |\n" +
                            "|         o_o         |\n" +
                            "|                     |\n" +
                            "|                     |\n" +
                            "|_____________________|  " );  */

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Enemy stats
        String[] enemies = {"Monster", "Scary Monster"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player stats
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true;

        System.out.println("Welcome to our shitty game!");

        //starting the game
        while(true) {
            System.out.println("\tEnter 1 to start game");
            String input = in.nextLine();
            if (input.equals("1")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }

        //Main game begins
        GAME:
        while(running) {
            System.out.println("------------------------------------------");

            //spawns enemy in room
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# OH NO, a " + enemy + " is in the room!!! #\n");

            // while alive, choose what to do
            while(enemyHealth > 0){
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat are you going to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink potion");
                System.out.println("\t3. Run to next room");

                //attack option
                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

                    if (health < 1){
                        System.out.println("\t> You have taken too much damage");
                        break;

                    }
                }

                //healing option
                else if(input.equals("2")){
                    if (numHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a potion, healing for " +healthPotionHealAmount + "."
                                            + "\n\t> You now have " + health + " HP."
                                            + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left");
                    }

                }

                //scaredy cat option
                else if(input.equals("3")){
                    System.out.println("\tYou have run away from the " + enemy + "!");
                    continue GAME;
                }

                //wrong input
                else{
                    System.out.println("\tInvalid command");

                }
            }

            //game ends if you run out of health
            if (health < 1){
                System.out.println("You limp out of the dungeon, weak from battle");
                break;
            }

            //this happens if you kill the monster (still needs the capturing mechanic instead of the potion dropping)
            System.out.println("------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" You now have " + numHealthPotions + " health potion(s). # ");

            }

            //choose to continue or nah
            System.out.println("------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue without fighting");
            System.out.println("2. exit dungeon");

            String input = in.nextLine();

            //invalid input
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command");
                input = in.nextLine();
            }

            //choose to continue playing
            if(input.equals("1")){
                System.out.println("you continue your adventure");
            }

            //choose to stop
            else if (input.equals("2")){
                System.out.println("You exit the dungeon, succesful");
                break;
            }
        }

        System.out.println("THANKS FOR PLAYING");

    }

}

