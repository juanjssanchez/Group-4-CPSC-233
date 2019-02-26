import java.util.Random; 
import java.util.Scanner;

public class Capture{
    Scanner in = new Scanner(System.in);

    private int min = 1;        /* minimum number 1*/
    private int max = 4;        /*Maximum number 4*/
    private int pass = 0;
    Random rand = new Random();     
    
    public void fourth(){       
        int capturerate =this.rand.nextInt((max - min) + 1) + min;  /* Generates number between 1 and 4 so capture rate is 25%*/

        if (capturerate == 1){      /*If 25% capture rate happens display outcome, if fail then display outcome*/
            System.out.println("Captured!");
            pass =1;          
        }else{
            System.out.println("~ Broke out of capture net!"); 
            System.out.println(""); 
            
        }
    }
    
    public void catchMode(){        /*Throw capture net at enemy*/
        while (pass!=1){
            System.out.println("Press 'Enter' to throw another net");
            String input = in.nextLine();

            if (input.equals("")) {     /* press enter to throw net*/
                fourth();
                if(pass ==1){       /*repeat until caaught*/
                    break;
                }
            }else{
                System.out.println("Invalid command");
            }
        }
    }
}
