/** each enum type has a static method called values().
It returns an array containing all of the values of the enum type
in the order in which they are declared*/

public enum Direction {
    /** enum constants with parameters dx and dy directions
    enum constants are implicitly public, static and final.
    we use enums because they are easy to read and compilers
    can catch errors. the arguments  of the constants (dx,dy) have to
    match the parameters of the constructor  */
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);


    private final int dx;    // instance variables
    private final int dy;

    private Direction (int dx, int dy){     // constructor (cant be public!)
        this.dx = dx;
        this.dy = dy;
    }


    /** to expose the values of the private constants to be accessed
    from the outside make a new public method*/
    public String directionvalue(){
        return String.format("(%d,%d)" ,NORTH,EAST,SOUTH,WEST);
    }
}
