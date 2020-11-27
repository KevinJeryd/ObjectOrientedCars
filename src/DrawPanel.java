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

    // Just a single image, TODO: Generalize
    //BufferedImage volvoImage;

    // To keep track of a singel cars position
    //Point volvoPoint = new Point();

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


    // TODO: Make this genereal for all cars
    void moveit(int x, int y, int index){
        vehiclePoints.get(index).x = x;
        vehiclePoints.get(index).y = y;
    }



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        // Print an error message in case file is not found with a try/catch block
        /*try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.


            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }*/

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
