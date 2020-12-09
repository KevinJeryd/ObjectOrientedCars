import javax.swing.*;

public class VehicleView implements VehicleObserver {
    private IController controller;
    public VehicleView(IController controller) {
        this.controller = controller;
    }
}
