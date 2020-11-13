import java.awt.*;

/**
 * Represents a car implementing the interfaces Vehicle and Movable.
 * This is an abstract class used to be extended by classes representing different car models.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public abstract class Car extends Vehicle implements Movable {
    /**
     * Constructs a Car object
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}
