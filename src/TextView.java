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
    public void actOnUpdate(Vehicle vehicle) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vehicleList.size(); i++) {
            sb.append("<html>" + vehicleList.get(i).getModelName() + " : " + (double) Math.round(100*vehicleList.get(i).getCurrentSpeed())/100 + "<br/> </hmtl>");
        }
        this.setText(sb.toString());
    }

    @Override
    public int getPanelHeight() {
        return (int) Double.POSITIVE_INFINITY;
    }

    @Override
    public int getPanelWidth() {
        return (int) Double.POSITIVE_INFINITY;
    }
}
