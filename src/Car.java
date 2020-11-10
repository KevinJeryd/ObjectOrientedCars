import java.awt.*;

public abstract class Car implements Vehicle, Movable {
    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private Direction facing;

    private double x;
    private double y;

    /**
     * Constructs a car object.
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
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

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

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
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
