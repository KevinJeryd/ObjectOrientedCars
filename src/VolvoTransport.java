import java.awt.*;
import java.util.Stack;

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

    public VolvoTransport(){
        super(2, Color.cyan, 900, "Volvo Transport");
        setRampUp(true);
    }

    public void loadCar (Car car) {
        if (carStack.size() > MAX_CARS) {
            throw new IllegalArgumentException("Transport already full");
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


    @Override
    public void move(){
        if (isRampUp()) {
            super.move();
        } else {
            throw new IllegalArgumentException("Raise the ramp first!");
        }
    }
}
