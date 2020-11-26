import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240(Direction.EAST, 0, 0));
        cc.vehicles.add(new Saab95(Direction.EAST, 0, 100));
        cc.vehicles.add(new Scania(Direction.EAST, 0, 200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {

                ChangeDirectionOnCollision(vehicle);

                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    //Checks if the car touches the wall, and changes direction
    private void ChangeDirectionOnCollision(Vehicle vehicle) {
        if (vehicle.getX() < 0) {
            vehicle.setFacing(Direction.EAST);
        } else if (vehicle.getX() + frame.drawPanel.volvoImage.getWidth() > frame.drawPanel.getWidth()) {
            vehicle.setFacing(Direction.WEST);
        } else if (vehicle.getY() < 0) {
            vehicle.setFacing(Direction.SOUTH);
        } else if (vehicle.getY() + frame.drawPanel.volvoImage.getHeight() > frame.drawPanel.getHeight()) {
            vehicle.setFacing(Direction.NORTH);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
}
