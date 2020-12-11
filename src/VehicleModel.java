import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleModel {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private  final int delay = 50;

    Timer timer = new Timer(delay, new VehicleModel.TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updater();
        }
    }

    private VehicleObserver view;
    private ArrayList<Vehicle> vehicleList;
    VehicleListFactory vehicleListFactory = new VehicleListFactory();

    ArrayList<ITurbo> turboList;
    ArrayList<IPlatform> platformList;
    ArrayList<IRamp> rampList;

    public VehicleModel (VehicleObserver view, ArrayList<Vehicle> vehicleList) {
        this.view = view;
        this.vehicleList = vehicleList;

        //Populate the different lists
        turboList = populateTurboList(vehicleList);
        platformList = populatePlatformList(vehicleList);
        rampList = populateRampList(vehicleList);
    }

    public void startTimer() {
        // Start the timer
        timer.start();
    }

    private ArrayList<ITurbo> populateTurboList(ArrayList<Vehicle> vehicles) {
        ArrayList<ITurbo> turboList = vehicleListFactory.turboListCreator();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ITurbo) {
                turboList.add((ITurbo) vehicle);
            }
        }
        return turboList;
    }

    private ArrayList<IPlatform> populatePlatformList(ArrayList<Vehicle> vehicles) {
        ArrayList<IPlatform> platformList = vehicleListFactory.platformListCreator();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof IPlatform) {
                platformList.add((IPlatform) vehicle);
            }
        }
        return platformList;
    }

    private ArrayList<IRamp> populateRampList(ArrayList<Vehicle> vehicles) {
        ArrayList<IRamp> rampList = vehicleListFactory.rampListCreator();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof IRamp) {
                rampList.add((IRamp) vehicle);
            }
        }
        return rampList;
    }

    public void updater() {
        for (int i = 0; i < vehicleList.size(); i++) {

            ChangeDirectionOnCollision(vehicleList.get(i));

            vehicleList.get(i).move();

            //System.out.println("I exist" + vehicleList.get(i).getModelName());

            view.actOnUpdate(vehicleList.get(i));
        }
    }

    //Checks if the car touches the wall, and changes direction
    private void ChangeDirectionOnCollision(Vehicle vehicle) {
        if (vehicle.getX() < 0) {
            vehicle.setFacing(Direction.EAST);
        } else if (vehicle.getX() + vehicle.getImage().getWidth() > view.getPanelWidth()) {
            vehicle.setFacing(Direction.WEST);
        } else if (vehicle.getY() < 0) {
            vehicle.setFacing(Direction.SOUTH);
        } else if (vehicle.getY() + vehicle.getImage().getHeight() > view.getPanelHeight()) {
            vehicle.setFacing(Direction.NORTH);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleList) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleList) {
            vehicle.brake(brake);
        }
    }

    void startVehicles() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getCurrentSpeed() == 0) {
                vehicle.startEngine();
            }
            //System.out.println("Engine on");
        }
    }

    void stopVehicles() {
        for (Vehicle vehicle : vehicleList) {
            vehicle.stopEngine();
            //System.out.println("Engine off");
        }
    }

    void setTurboOn() {
        for (ITurbo vehicle: turboList) {
            vehicle.setTurboOn();
            //System.out.println("Turbo on");
        }
    }

    void setTurboOff() {
        for (ITurbo vehicle : turboList) {
            vehicle.setTurboOff();
            //System.out.println("Turbo off");
        }
    }

    void lowerBed() {
        for (IPlatform vehicle: platformList) {
            vehicle.setPlatform(0);
            //System.out.println("Lower bed");
        }
    }

    void liftBed() {
        for (IPlatform vehicle: platformList){
            vehicle.setPlatform(70);
            //System.out.println("Lifts bed");

        }
    }

}

