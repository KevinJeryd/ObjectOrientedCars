import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleApp {
    // member fields:

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.


    // The controller
    static VehicleController controller;

    // Factory
    static VehicleFactory vehicleFactory = new VehicleFactory();

    //methods:

    public static void main(String[] args) {

        //Add vehicles
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicleFactory.saabCreator(Direction.EAST, 0, 0));
        //vehicleList.add(vehicleFactory.volvoTransportCreator(Direction.EAST, 0, 100));
        //vehicleList.add(vehicleFactory.scaniaCreator(Direction.EAST, 0, 200));
        //vehicleList.add(vehicleFactory.volvoCreator(Direction.EAST, 0, 300));

        // Start a new model, view and controller
        controller = new VehicleController();

        VehicleView view = new VehicleView("VehicleFrame", controller);

        VehicleModel model = new VehicleModel(view, vehicleList);

        controller.setModel(model);

        model.startTimer();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

}
