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
    ArrayList<Vehicle> vehicleList;

    public void setCurrentVehicle(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
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
        //System.out.println("I exist " + currentVehicle.getModelName());
        super.paintComponent(g);
        for (int i = 0; i < vehicleList.size(); i++) {
            g.drawImage(vehicleList.get(i).getImage(), (int) Math.round(vehicleList.get(i).getX()), (int) Math.round(vehicleList.get(i).getY()), null);
        }
         // see javadoc for more info on the parameters
    }
}
