public class VehicleController implements IController{
    private VehicleModel model;
    public int gasAmount;

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    void onUpdate() {
        model.updater();
    }

    public void onGasActivated() {
        model.gas(gasAmount);
    }

    public void onBrakeActivated() {
        model.brake(gasAmount);
    }

    public void onStartActivated() {
        model.startVehicles();
    }

    public void onStopActivated() {
        model.stopVehicles();
    }

    public void onSetTurboOnActivated() {
        model.setTurboOn();
    }

    public void onSetTurboOffActivated() {
        model.setTurboOff();
    }

    public void onLowerBedActivated() {
        model.lowerBed();
    }

    public void onLiftBedActivated() {
        model.liftBed();
    }

    public void onSpinnerChange(int i) {
        gasAmount = i;
    }

}
