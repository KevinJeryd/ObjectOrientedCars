import java.util.ArrayList;

public interface VehicleObserver {
    public void actOnUpdate(Vehicle vehicle);
    public int getPanelHeight();
    public int getPanelWidth();
}
