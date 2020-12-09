public class VehicleController implements IController{
    private VehicleModel model;
    public int gasAmount;

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    void onUpdate() {
        model.updater();
    }

}
