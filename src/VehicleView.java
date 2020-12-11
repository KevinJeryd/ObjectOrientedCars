import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleView extends JPanel implements VehicleObserver {


    public void actOnUpdate(Vehicle vehicle) {
        this.repaint();
    }

    private static final int X = 1000;
    private static final int Y = 800;

    //Vehicles
    private final ArrayList<Vehicle> vehicleList;

    // Initializes the panel and reads the images
    public VehicleView(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(X, Y-240));
        this.setBackground(Color.green);
    }

    @Override
    public int getPanelHeight() {
        return this.getHeight();
    }

    @Override
    public int getPanelWidth() {
        return this.getWidth();
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("I exist " + currentVehicle.getModelName());
        super.paintComponent(g);
        for (Vehicle vehicle : vehicleList) {
            g.drawImage(vehicle.getImage(), (int) Math.round(vehicle.getX()), (int) Math.round(vehicle.getY()), null);
        }
        // see javadoc for more info on the parameters
    }

}
