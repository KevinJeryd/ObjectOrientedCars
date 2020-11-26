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
    BufferedImage volvoImage;
    ArrayList<BufferedImage> vehicleImages;
    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    ArrayList<Point> vehiclePoints;

    int amountOfVehicles;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController carC) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        amountOfVehicles = carC.vehicles.size();

        for (int i = 0; i < carC.vehicles.size(); i++) {
            vehiclePoints.add(new Point());
        }
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.


            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < amountOfVehicles; i++) {
            g.drawImage(volvoImage, vehiclePoints.get(i).x, vehiclePoints.get(i).y, null);
        }
         // see javadoc for more info on the parameters
    }
}
