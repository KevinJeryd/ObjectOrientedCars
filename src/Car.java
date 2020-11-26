import java.awt.*;

/**
 * Represents a car extending the class Vehicle.
 * This is an abstract class used to be extended by classes representing different car models.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public abstract class Car extends Vehicle {
    /**
     * Constructs a Car object
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName, Direction facing, double x, double y) {
        super(nrDoors, color, enginePower, modelName, facing, x, y);
    }
}
