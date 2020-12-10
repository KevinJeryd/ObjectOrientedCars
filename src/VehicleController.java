import javax.swing.*;
import java.awt.event.ActionEvent;

public class VehicleController implements IController, ISpinner{
    private VehicleModel model;
    public int gasAmount = 0;

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    void onUpdate() {
        model.updater();
    }

    public void onGasActivated() {
        model.gas(gasAmount);
    }

    @Override
    public void onButtonClick(JButton button) {
        System.out.println(button.getName());
        switch (button.getName()) {
            case "gasButton":
                model.gas(gasAmount);
                break;
            case "brakeButton":
                model.brake(gasAmount);
                break;
            case "startButton":
                model.startVehicles();
                break;
            case "stopButton":
                model.stopVehicles();
                break;
            case "turboOnButton":
                model.setTurboOn();
                break;
            case "turboOffButton":
                model.setTurboOff();
                break;
            case "liftBedButton":
                model.liftBed();
                break;
            case "lowerBedButton":
                model.lowerBed();
                break;
        }

    }

    @Override
    public void onSpinnerChange(int gasAmount) {
        this.gasAmount = gasAmount;
    }

}
