public enum Direction {
    // enum constants with parameters dx and dy directions 
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);



    private Direction (int dx, int dy){     // constructor
        this.dx = dx;
        this.dy = dy;
    }
    private final int dx;    // instance variables
    private final int dy;


}
