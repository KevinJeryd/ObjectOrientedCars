public interface Movable {
    /**
     *  Maybe move ENUM direction to here so more classes can use it (eg boats, airplanes etc etc)
     */
    void move();
    void turnLeft();
    void turnRight();
}
