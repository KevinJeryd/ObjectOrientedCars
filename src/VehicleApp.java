import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleApp {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.


    // The controller
    VehicleController controller;

    // Factory
    VehicleFactory vehicleFactory = new VehicleFactory();

    //methods:

    public void main(String[] args) {

        //Add vehicles
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicleFactory.saabCreator(Direction.EAST, 0, 0));
        vehicleList.add(vehicleFactory.volvoTransportCreator(Direction.EAST, 0, 0));
        vehicleList.add(vehicleFactory.scaniaCreator(Direction.EAST, 0, 0));
        vehicleList.add(vehicleFactory.volvoCreator(Direction.EAST, 0, 0));

        // Start a new model, view and controller
        controller = new VehicleController();

        VehicleView view = new VehicleView(controller);

        VehicleModel model = new VehicleModel(view, vehicleList);

        controller.setModel(model);

        Timer timer = new Timer(delay, new VehicleApp.TimerListener());

        // Start the timer
        timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            controller.onUpdate();
        }
    }
}
