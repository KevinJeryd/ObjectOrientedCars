import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Represents a vehicle.
 * This is an abstract class used to be extended by classes representing different vehicles.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public abstract class Vehicle implements Movable{

    /**
     * Number of doors on the vehicle
     */
    private final int nrDoors;
    /**
     * Engine power of the vehicle
     */
    private final double enginePower;
    /**
     * The current speed of the vehicle
     */
    private double currentSpeed;
    /**
     * Color of the vehicle
     */
    private Color color;
    /**
     * The vehicle model name
     */
    private final String modelName;

    /**
     * Direction the vehicle is facing
     */
    private Direction facing;

    /**
     * X-position of the vehicle
     */
    private double x;
    /**
     * Y-position of the vehicle
     */
    private double y;

    private BufferedImage Image;

    /**
     * Constructs a car object.
     * @param nrDoors Number of doors on the vehicle
     * @param color Color of the vehicle
     * @param enginePower Engine power of the vehicle
     * @param modelName The vehicle model name
     */
    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, Direction facing, double x, double y) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        setFacing(facing);
        setX(x);
        setY(y);
        stopEngine();

        try {
            Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + getModelName() + ".jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return Image;
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
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Increments the speed
     * @param amount a double containing a value in which the car speed increments
     */
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrements the speed
     * @param amount a double containing a value in which the vehicle speed decrements
     */
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /** Moves the vehicle in the direction the vehicle is facing.
     * Changes the x or y coordinates of the vehicle with the amount of current speed.
     */
    public void move(){
        if (getFacing() == Direction.NORTH) {
            setY(getY()-getCurrentSpeed());
        } else if (getFacing()== Direction.EAST) {
            setX(getX()+getCurrentSpeed());
        } else if (getFacing() == Direction.SOUTH) {
            setY(getY()+getCurrentSpeed());
        } else if (getFacing() == Direction.WEST) {
            setX(getX()-getCurrentSpeed());
        }
    }
    /**
     * Turns the vehicle left.
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
     * Turns the vehicle right.
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
