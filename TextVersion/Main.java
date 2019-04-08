import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


/* *** Extremely rough draft of how the text based game might work ***
     -this is just a starting point to work from
     -still need to incorporate the other classes to work with this

     Use WASD and press ENTER to move
     Player is represented by X and enemies by M
     Move near enemy to trigger combat stage
     Theres only one map right now
     Note: although the enemies always start in same spot, their stats are randomized
     */


public class Main{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Player stats
        Player player = new Player(100, 50);

        int healthPotionDropChance = 50; //percentage//

        boolean running = true;
        boolean walking = true;
        Capture captureObject = new Capture();

        System.out.println("__          __  _ \n" +
                "\\ \\        / / | |\n" +
                " \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___ \n" +
                "  \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ \n" +
                "   \\  /\\  /  __/ | (_| (_) | | | | | |  __/\n" +
                "    \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|");

        //starting the game
        while(true) {
            System.out.println("\t\nPress ENTER to start game");
            String input = in.nextLine();
            if (input.equals("")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }

        //creates map object
        Map map1 = new Map();

        //Main game begins
        GAME:
        while(running) {
            System.out.println("------------------------------------------\n");

            //movement around map
            while(walking){
                //updates screen
                for (int i = 0; i < map1.getMap().length; i++) {
                    for (int j = 0; (map1.getMap()[i] != null && j < map1.getMap()[i].length); j++)
                        System.out.print(map1.getMap()[i][j] + " ");
                    System.out.println();
                }
                System.out.println("Number of captives: " + player.getNumCaptives());


                String input = in.nextLine();
                //move around screen
                map1.move(input);

                //checks for nearby enemies
                walking = map1.checkEnemy();
            }
            walking = true;

            //creates enemy
            Enemy enemy = new Enemy(75, 25);
            System.out.println("\n\t# OH NO, there's a monster!! #\n");

            // while enemy alive, choose what to do
            while(enemy.alive()){
                System.out.println("\tYour HP: " + player.getHealth());
                System.out.println("\t Enemy's HP: " + enemy.getHealth());
                System.out.println("\n\tWhat are you going to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink potion");
                System.out.println("\t3. Run to next room");

                //attack option
                String input = in.nextLine();
                if(input.equals("1")){
                    int playerAttack = rand.nextInt(player.getAttackDamage());
                    int enemyAttack = rand.nextInt(enemy.getAttackDamage());

                    enemy.decreaseHealth(playerAttack);
                    player.decreaseHealth(enemyAttack);

                    System.out.println("\t> You strike the enemy for " + playerAttack + " damage.");
                    System.out.println("\t> You recieve " + enemyAttack + " in retaliation!");

                    if (!player.alive()){
                        System.out.println("\t> You have taken too much damage");
                        break;

                    }
                }

                //healing option
                else if(input.equals("2")){
                    if (player.getNumPotions() > 0){
                        player.usePotion();
                        System.out.println("\t> You drink a potion, healing for 30."
                                + "\n\t> You now have " + player.getHealth() + " HP."
                                + "\n\t> You have " + player.getNumPotions() + " health potions left.\n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left");
                    }

                }

                //scaredy cat option
                else if(input.equals("3")){
                    System.out.println("\tYou have run away from the monster!");
                    continue GAME;
                }

                //wrong input
                else{
                    System.out.println("\tInvalid command");

                }
            }

            //game ends if you run out of health
            if (!player.alive()){
                System.out.println("You limp out of the dungeon, weak from battle");
                break;
            }

            //this happens when you kill the monster
            System.out.println("------------------------------------------");
            Capture Catch = new Capture();
            Catch.catchMode();
            System.out.println(" # You have " + player.getHealth() + " HP left. # ");
            if(rand.nextInt(100) < healthPotionDropChance){
                player.addPotion();
                System.out.println(" # The enemy dropped a health potion! # ");
                System.out.println(" You now have " + player.getNumPotions() + " health potion(s). # ");
            }
            //adds to amount of captives
            player.addCaptive();

            //updates map to get rid of Monster
            map1.deadEnemy();

            //choose to continue or stop
            System.out.println("------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue");
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
