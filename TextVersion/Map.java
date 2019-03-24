import java.util.Arrays;

public class Map extends Main{

    private char[][] arr;
    private char[][] currentRoom;

    //layout of each screen/room
    private char[][] startRoom = new char[][]{   /*Start room where player spawns*/
            {'H', 'H', 'H', 'H', 'D', 'H', 'H', 'H', 'H'},
            {'H', ' ', ' ', ' ', 'M', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'H'},
            {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
    };
    private char[][] mainRoom = new char[][]{        /* Center room of map*/
            {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'D', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'D', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'D'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'D', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
    };
    private char[][] leftRoom = new char[][]{            /*left room*/
            {'H', 'H', 'H', 'H', 'H', 'H', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', 'M', ' ', ' ', 'X', 'D'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', 'H', 'H', 'H', 'H', 'H', 'H'},
    };
    private char[][] rightRoom = new char[][]{           /* right room */
            {'H', 'H', 'H', 'H', 'H', 'H', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'D', 'X', ' ', ' ', 'M', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', 'H', 'H', 'H', 'H', 'H', 'H'},
    };
    private char[][] bossRoom = new char[][]{            /* Final boss room*/
            {'H', 'H', 'H', 'H', 'H', 'H', 'H'},
            {'H', ' ', ' ', 'M', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', ' ', ' ', ' ', 'H'},
            {'H', ' ', ' ', 'X', ' ', ' ', 'H'},
            {'H', 'H', 'H', 'D', 'H', 'H', 'H'},
    };

    //constructor
    Map(){
        arr = startRoom;
        currentRoom = startRoom;
    }


    //returns the map
    public char[][] getMap(){
        return arr;
    }

    //removes the enemy from map after it is killed
    public void deadEnemy(){
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (arr[i][j] == 'M') {
                    if (arr[i+1][j] == 'X' || arr[i-1][j] == 'X' || arr[i][j+1] == 'X' || arr[i][j-1] == 'X') {
                        arr[i][j] = ' ';
                    }
                }
    }

    //checks for enemies nearby
    public boolean checkEnemy(){
        //enemy nearby
        int check = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
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

    //returns current room array
    public char[][] getCurrentRoom(){
        return currentRoom;
    }

    //updates to the current room
    public void updateRoom(char[][] room){
        currentRoom = room;
    }

    //returns current room as a String
    public String getRoomString(){
        if(currentRoom == mainRoom){
            return "mainRoom";
        }
        if (currentRoom == leftRoom) {
            return "leftRoom";
        }
        if (currentRoom == rightRoom) {
            return "rightRoom";
        }
        if (currentRoom == bossRoom) {
            return "bossRoom";
        } else {return "startRoom";}
    }

    //updates map to represent player movement
    public void move(String input){

        //moves using WASD and ENTER
        moveloop:
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (arr[i][j] == 'X') {
                    if (input.equals("w")) {
                        if (arr[i - 1][j] == ' ') {  //if space is available, player will move there
                            arr[i][j] = ' ';
                            arr[i - 1][j] = 'X';
                            break;
                        }
                        if (arr[i - 1][j] == 'D' && getRoomString() == "startRoom") { //if space is a door(D),
                            updateRoom(mainRoom);                                     //room will change
                            arr = getCurrentRoom();
                            break;
                        } else {
                            updateRoom(bossRoom);
                            arr = getCurrentRoom();
                            break;
                        }
                    }
                    else if (input.equals("a")) {
                        if (arr[i][j - 1] == ' ') {
                            arr[i][j] = ' ';
                            arr[i][j - 1] = 'X';
                            break;
                        }
                        if (arr[i][j - 1] == 'D' && getRoomString() == "mainRoom") {
                            updateRoom(leftRoom);
                            arr = getCurrentRoom();
                            break;
                        }
                        if (arr[i][j - 1] == 'D' && getRoomString() == "rightRoom") {
                            updateRoom(mainRoom);
                            arr = getCurrentRoom();
                            break;
                        }
                    }
                    else if (input.equals("d")) {
                        if (arr[i][j + 1] == ' ') {
                            arr[i][j] = ' ';
                            arr[i][j + 1] = 'X';
                            break;
                        }
                        if (arr[i][j + 1] == 'D' && getRoomString() == "leftRoom") {
                            updateRoom(mainRoom);
                            arr = getCurrentRoom();
                            break;
                        }
                        if (arr[i][j + 1] == 'D' && getRoomString() == "mainRoom") {
                            updateRoom(rightRoom);
                            arr = getCurrentRoom();
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
                        if (arr[i + 1][j] == 'D' && getRoomString() == "mainRoom") {
                            updateRoom(startRoom);
                            arr = getCurrentRoom();
                            break;
                        } else { System.out.println("No turning back");}
                    }
                }
    }



}

