import java.util.*;

public abstract class VehicleWorkshop<T extends Vehicle> {
    private final int maxCapacity;
    private final ArrayList<T> vehicles = new ArrayList<>();

    public VehicleWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ArrayList<T> getVehicles() {
        return vehicles;
    }

    public void load(T vehicle) {
        if (getVehicles().size() <= maxCapacity) {
            getVehicles().add(vehicle);
        } else {
            throw new IndexOutOfBoundsException("The workshop is full.");
        }
    }

    public T unload(int i) {
        if (!getVehicles().isEmpty()) {
            return getVehicles().remove(i);
        } else {
            throw new IndexOutOfBoundsException("The workshop is empty.");
        }
    }


}
