import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


/* *** Extremely rough draft of how the text based game might work ***
     -this is just a starting point to work from
     -still need to incorporate the other classes to work with this 
     UPDATE: ive added a single screen where you can move around using WASD and then pressing ENTER everytime,
             -the player is represented by an X
             -the monster is represented by an M
             -when you get close to the monster, the combat stage will appear
     
*/


public class Main extends Map{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Enemy stats, ***this should be in an enemy or person class****
        String[] enemies = {"Monster", "Scary Monster"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player stats ***playerclass**
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true;
        boolean walking = true;

        System.out.println("__          __  _ \n" +
                "\\ \\        / / | |\n" +
                " \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___ \n" +
                "  \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ \n" +
                "   \\  /\\  /  __/ | (_| (_) | | | | | |  __/\n" +
                "    \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|");


        //two dimensional array(map) *** map class ***
        char[][] arr = {
                {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
        };


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

        //Main game begins
        GAME:
        while(running) {
            System.out.println("------------------------------------------\n");

            //movement around screen
            while(walking){
                //updates screen
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; (arr[i] != null && j < arr[i].length); j++)
                        System.out.print(arr[i][j] + " ");
                    System.out.println();
                }

                //moves using WASD and ENTER
                String input = in.nextLine();
                moveloop:
                for (int i = 0; i < 9; i++)
                    for (int j = 0; j < 16; j++)
                        if (arr[i][j] == 'X') {
                            if (input.equals("w")) {
                                if (arr[i - 1][j] == ' ') {
                                    arr[i][j] = ' ';
                                    arr[i - 1][j] = 'X';
                                    break;
                                }
                            }
                            else if (input.equals("a")) {
                                if (arr[i][j - 1] == ' ') {
                                    arr[i][j] = ' ';
                                    arr[i][j - 1] = 'X';
                                    break;
                                }
                            }
                            else if (input.equals("d")) {
                                if (arr[i][j + 1] == ' ') {
                                    arr[i][j] = ' ';
                                    arr[i][j + 1] = 'X';
                                    break;
                                }
                            }
                            else if (input.equals("s")) {
                                if (arr[i + 1][j] == ' ') {
                                    arr[i][j] = ' ';
                                    arr[i + 1][j] = 'X';
                                    System.out.println('w');
                                    break moveloop;
                                }
                            }
                        }
                //enemy nearby
                for (int i = 0; i < 9; i++)
                    for (int j = 0; j < 16; j++)
                        if (arr[i][j] == 'X'){
                            if (arr[i+1][j] == 'M' || arr[i-1][j] == 'M' || arr[i][j+1] == 'M' || arr[i][j-1] == 'M'){
                                walking = false;
                            }
                        }
            }
            walking = true;

            //spawns enemy in room
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\n\t# OH NO, there's a " + enemy + "!! #\n");

            // while enemy alive, choose what to do
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

            //this happens when you kill the monster
            System.out.println("------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" You now have " + numHealthPotions + " health potion(s). # ");
            }
             
            //updates map to get rid of Monster
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 16; j++)
                    if (arr[i][j] == 'M') {
                        arr[i][j] = ' ';
                    }

            //choose to continue or nah
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

