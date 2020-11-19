import java.util.*;

/**
 * Represents a vehicle workshop.
 * The type of workshop is specified inside angle brackets
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
//T extend vehicle == t only can be something that extends vehicle.
public class VehicleWorkshop<T extends Vehicle> {

    /**
     * The max capacity of the workshop (how many vehicles it can hold)
     */
    private final int maxCapacity;
    /**
     * The list representing the vehicles inside the workshop
     */
    private final ArrayList<T> vehicles = new ArrayList<>();

    /**
     *Constructs a vehicle workshop
     * @param maxCapacity - the max capacity of the workshop (how many vehicles it can hold)
     */
    public VehicleWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ArrayList<T> getVehicles() {
        return vehicles;
    }

    /**
     * Loads a vehicle into the workshop
     * @param vehicle - The vehicle that is supposed to be loaded into the workshop
     */
    public void load(T vehicle) {
        if (getVehicles().size() < maxCapacity) {
            getVehicles().add(vehicle);
        } else {
            throw new IndexOutOfBoundsException("The workshop is full.");
        }
    }

    /**
     * Unloads your vehicle from the workshop.
     * If the car is not found it will throw an error saying it wasn't found in the workshop.
     * @param vehicle - a type of vehicle
     * @return the type of the vehicle passed in
     */
    public T unload(T vehicle) {
        if (!getVehicles().isEmpty()) {
            for (int i = 0; i < getVehicles().size(); i++){
                if (getVehicles().get(i).equals(vehicle)) {
                    return getVehicles().remove(i);
                }
            }
        }
        throw new IndexOutOfBoundsException("Your car was not found in the workshop.");
    }
}
