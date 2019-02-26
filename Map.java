import java.util.Arrays;

public class Map{

    private char[][] arr;

    Map(){
        arr = new char[][]{
                {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', 'M', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
                {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
        };
    }

    public char[][] getMap(){
        return arr;
    }





    //idk about these
    public char getElement(Location location){

        return '\u0000';
    }

    public boolean isValidMove(Location currentLocation){

        return true;
    }

    public void deadEnemy(){
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 16; j++)
                if (arr[i][j] == 'M') {
                    if (arr[i+1][j] == 'X' || arr[i-1][j] == 'X' || arr[i][j+1] == 'X' || arr[i][j-1] == 'X') {
                        arr[i][j] = ' ';
                    }
                }
    }

    public boolean checkEnemy(){
        //enemy nearby
        int check = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 16; j++)
                if (arr[i][j] == 'X'){
                    if (arr[i+1][j] == 'M' || arr[i-1][j] == 'M' || arr[i][j+1] == 'M' || arr[i][j-1] == 'M'){
                        check = 1;
                    }
                }
        if (check == 1){
            return false;
        } else{
            return true;
        }
    }

    public void move(String input){
        //moves using WASD and ENTER
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
    }



}


