import java.awt.*;

/**
 * Represents a truck extending the class Vehicle.
 * This is an abstract class used to be extended by classes representing different truck models.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public abstract class Truck extends Vehicle{

   /**
    * Constructs a Truck object
    * @param nrDoors
    * @param color
    * @param enginePower
    * @param modelName
    */
   public Truck(int nrDoors, Color color, double enginePower, String modelName, Direction facing, double x, double y) {
      super(nrDoors, color, enginePower, modelName, facing, x, y);
   }
}
