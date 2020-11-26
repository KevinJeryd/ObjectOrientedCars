import java.awt.*;
import java.util.Stack;
import java.math.*;

/**
 * Represents a VolvoTransport extending the class Truck.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public class VolvoTransport extends Truck{
    /**
     * Is the platform up? (true or false)
     */
    private boolean rampUp;

    /**
     *The max amount of cars that can be loaded onto the transport.
     */
    private final int MAX_CARS = 4;

    /**
     * Represents the cars that are loaded onto the transport.
     * Is a stack because first-in-last-out.
     */
    private Stack<Car> carStack = new Stack<Car>();

    /**
     * Constructs a VolvoTransport
     */
    public VolvoTransport(Direction facing, double x, double y){
        super(2, Color.cyan, 900, "Volvo Transport", facing, x, y);
        setRampUp(true);
    }

    /**
     * Loads the transport with the car
     * Can't load more than 4 cars
     * Can't load if car is too far away from the transport
     * @param car
     */
    public void loadCar (Car car) {
        lowerRamp(); //lowers the ramp
        //Can't load more than max_cars
        if (carStack.size() >= MAX_CARS) {
            throw new IndexOutOfBoundsException("Transport already full");
        }

        //At least 1 step from the truck
        if (Math.abs(car.getX()-getX()) <= 1 && Math.abs(car.getY()-getY()) <= 1) {
            carStack.push(car);
            car.setX(getX());
            car.setY(getY());
        } else {
            throw new IllegalArgumentException("The car is too far away from the transport");
        }
    }

    /**
     * Can't unload if the transport is empty
     * @return car - returns the last loaded car
     */
    public Car unloadCar() {
        lowerRamp(); //lowers the ramp
        if (carStack.size() == 0) {
            throw new IndexOutOfBoundsException("Transport already empty");
         } else {
            Car car = carStack.pop();
            car.setX(car.getX()-1);
            return car;
        }
    }

    public Stack<Car> getCarStack() {
        return carStack;
    }

    public boolean isRampUp() {
        return rampUp;
    }

    public void setRampUp(boolean platformUp) {
        this.rampUp = platformUp;
    }

    /**
     * lowers the ramp
     */
    public void lowerRamp() {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("You can't drive and lower the ramp!");
        } else {
            setRampUp(false);
        }
    }

    /**
     * raises the ramp
     */
    public void raiseRamp() {
        setRampUp(true);
    }


    /**
     * Moves the transport and the cars loaded onto the transport.
     * Can't move when ramp is down.
     */
    @Override
    public void move(){
        if (isRampUp()) {
            super.move();
            for (int i = 0; i < carStack.size(); i++) { //moves the cars inside the transport too
                carStack.get(i).setX(getX());
                carStack.get(i).setY(getY());
            }
        } else {
            throw new IllegalArgumentException("Raise the ramp first!");
        }
    }
}
