import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //Vehicles and points

    ArrayList<BufferedImage> vehicleImages = new ArrayList<>();
    ArrayList<Point> vehiclePoints = new ArrayList<>();

    void setUpVehicles(ArrayList<Vehicle> list) {
        for (Vehicle vehicle : list) {
            setImage(vehicle);
            setVehiclePoints();
        }
    }

    private void setImage(Vehicle vehicle) {
        BufferedImage vehicleImage;
        try {
            vehicleImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg"));
            vehicleImages.add(vehicleImage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setVehiclePoints() {
        Point vehiclePoint = new Point();
        vehiclePoints.add(vehiclePoint);
    }


    // Generalized for all vehicle
    void moveit(int x, int y, int index){
        vehiclePoints.get(index).x = x;
        vehiclePoints.get(index).y = y;
    }



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < vehiclePoints.size(); i++) {
            g.drawImage(vehicleImages.get(i), vehiclePoints.get(i).x, vehiclePoints.get(i).y, null);
        }
         // see javadoc for more info on the parameters
    }
}
