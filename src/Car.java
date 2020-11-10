import java.awt.*;

/**
 * Represents a car implementing the interfaces Vehicle and Movable.
 * This is an abstract class used to be extended by classes representing different car models.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public abstract class Car implements Vehicle, Movable {
    /**
     * Enumeration representing the different direction the car can face.
     */
    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    /**
     * int nrDoors; - Number of doors on the car
     * double enginePower; - Engine power of the car
     * double currentSpeed; - The current speed of the car
     * Color color; Color of the car
     * String modelName; The car model name
     * Direction facing; Facing direction of the car
     */
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    private Direction facing;

    private double x;
    private double y;

    /**
     * Constructs a car object.
     * @param nrDoors Number of doors on the car
     * @param color Color of the car
     * @param enginePower Engine power of the car
     * @param modelName The car model name
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the current speed to 0.1
     */
    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    /**
     * Sets the current speed to 0
     */
    public void stopEngine(){
        setCurrentSpeed(0);
    }

    /**
     * Calculates the speed factor
     * @return double containing the speed factor
     */
    public abstract double speedFactor();

    /**
     * Increments the speed
     * @param amount a double containing a value in which the car speed increments
     */
    public abstract void incrementSpeed(double amount);

    /**
     * Decrements the speed
     * @param amount a double containing a value in which the car speed decrements
     */
    public abstract void decrementSpeed(double amount);

    /**
     * Moves the car in the direction the car is facing.
     * Changes the x or y coordinates of the car with the amount of current speed.
     */
    public void move(){
        if (getFacing() == Direction.NORTH) {
            setY(getY()+getCurrentSpeed());
        }
        if (getFacing()== Direction.EAST) {
            setX(getX()+getCurrentSpeed());
        }
        if (getFacing() == Direction.SOUTH) {
            setY(getY()-getCurrentSpeed());
        }
        if (getFacing() == Direction.WEST) {
            setX(getX()-getCurrentSpeed());
        }
    }

    /**
     * Turns the car left.
     * Changes the value of facing to the direction left of the current direction
     */
    public void turnLeft() {
        if (getFacing() == Direction.NORTH) {
            setFacing(Direction.WEST);
        }
        if (getFacing() == Direction.EAST) {
            setFacing(Direction.NORTH);
        }
        if (getFacing() == Direction.SOUTH) {
            setFacing(Direction.EAST);
        }
        if (getFacing() == Direction.WEST) {
            setFacing(Direction.SOUTH);
        }
    }

    /**
     * Turns the car right.
     * Changes the value of facing to the direction left of the current direction
     */
    public void turnRight() {
        if (getFacing() == Direction.NORTH) {
            setFacing(Direction.EAST);
        }
        if (getFacing() == Direction.EAST) {
            setFacing(Direction.SOUTH);
        }
        if (getFacing() == Direction.SOUTH) {
            setFacing(Direction.WEST);
        }
        if (getFacing() == Direction.WEST) {
            setFacing(Direction.NORTH);
        }
    }

    // TODO fix this method according to lab pm (make if statements that only allows 0 < x < 1)

    /**
     * Increments the speed.
     * @param amount a double containing the value that the speed should increment with
     */
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * Decrements the speed.
     * @param amount a double containing the value that the speed should decrement with
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
