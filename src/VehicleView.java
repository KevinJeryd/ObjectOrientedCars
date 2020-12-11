import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleView extends JPanel implements VehicleObserver {


    public void actOnUpdate() {
        this.repaint();
    }

    //Vehicles
    private final ArrayList<Vehicle> vehicleList;

    HashMap<Vehicle, Image> vehicleImageHashMap = new HashMap<>();

    // Initializes the panel and reads the images
    public VehicleView(ArrayList<Vehicle> vehicleList, int width, int height) {
        this.vehicleList = vehicleList;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);

        for (Vehicle vehicle : vehicleList) {
            try {
                Image image = ImageIO.read(VehicleView.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg")).getScaledInstance(vehicle.getWidth(), vehicle.getHeight(), Image.SCALE_DEFAULT);
                vehicleImageHashMap.put(vehicle, image);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("I exist " + currentVehicle.getModelName());
        super.paintComponent(g);
        for (Vehicle vehicle : vehicleList) {
            g.drawImage(vehicleImageHashMap.get(vehicle), (int) Math.round(vehicle.getX()), (int) Math.round(vehicle.getY()), null);
        }
        // see javadoc for more info on the parameters
    }

}
