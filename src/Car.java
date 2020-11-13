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
     * Number of doors on the car
     */
    private final int nrDoors;
    /**
     * Engine power of the car
     */
    private final double enginePower;
    /**
     * The current speed of the car
     */
    private double currentSpeed;
    /**
     * Color of the car
     */
    private Color color;
    /**
     * The car model name
     */
    private final String modelName;

    /**
     * Direction the car is facing
     */
    private Direction facing;

    /**
     * X-position of the car
     */
    private double x;
    /**
     * Y-position of the car
     */
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

    public String getModelName() { return modelName;};

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
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrements the speed
     * @param amount a double containing a value in which the car speed decrements
     */
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /** Moves the car in the direction the car is facing.
     * Changes the x or y coordinates of the car with the amount of current speed.
     */
    public void move(){
        if (getFacing() == Direction.NORTH) {
            setY(getY()+getCurrentSpeed());
        } else if (getFacing()== Direction.EAST) {
            setX(getX()+getCurrentSpeed());
        } else if (getFacing() == Direction.SOUTH) {
            setY(getY()-getCurrentSpeed());
        } else if (getFacing() == Direction.WEST) {
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
        } else if (getFacing() == Direction.EAST) {
            setFacing(Direction.NORTH);
        } else if (getFacing() == Direction.SOUTH) {
            setFacing(Direction.EAST);
        } else if (getFacing() == Direction.WEST) {
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
        } else if (getFacing() == Direction.EAST) {
            setFacing(Direction.SOUTH);
        } else if (getFacing() == Direction.SOUTH) {
            setFacing(Direction.WEST);
        } else if (getFacing() == Direction.WEST) {
            setFacing(Direction.NORTH);
        }
    }
    /**
     * Increments the speed.
     * @param amount a double containing the value that the speed should increment with
     * @throws IllegalArgumentException if amount given falls outside range [0,1]
     */
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Only accepts amount between 0 and 1");
        }
    }
    /**
     * Decrements the speed.
     * @param amount a double containing the value that the speed should decrement with
     * @throws IllegalArgumentException if amount given falls outside range [0,1]
     */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Only accepts amount between 0 and 1");
        }
    }
}
