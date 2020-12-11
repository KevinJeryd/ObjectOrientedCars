import org.junit.runner.OrderWith;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.util.ArrayList;

public class TextView extends JFrame implements VehicleObserver {

    @Override
    public void actOnUpdate(Vehicle vehicle) {
        System.out.print(vehicle.getModelName() + " : ");
        System.out.println(vehicle.getCurrentSpeed());
    }

    @Override
    public int getPanelHeight() {
        return 900;
    }

    @Override
    public int getPanelWidth() {
        return 900;
    }
}
