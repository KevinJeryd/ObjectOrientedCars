import org.junit.runner.OrderWith;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TextView extends JLabel implements VehicleObserver {

    private final ArrayList<Vehicle> vehicleList;

    TextView(ArrayList<Vehicle> vehicleList) {
        this.setPreferredSize(new Dimension(200,100));
        this.vehicleList = vehicleList;
    }

    @Override
    public void actOnUpdate() {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : vehicleList) {
            sb.append("<html>" + vehicle.getModelName() + " : " + (double) Math.round(100 * vehicle.getCurrentSpeed()) / 100 + "<br/> </hmtl>");
        }
        this.setText(sb.toString());
    }

}
