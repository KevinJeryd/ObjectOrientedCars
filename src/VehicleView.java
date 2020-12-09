import javax.swing.*;
import java.util.ArrayList;

public class VehicleView implements VehicleObserver {
    private IController controller;
    public VehicleView(IController controller) {
        this.controller = controller;
    }

    public void actOnPositionChange(ArrayList<Vehicle> vehicleList) {

    }
}
