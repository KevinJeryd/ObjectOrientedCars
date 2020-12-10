import java.util.ArrayList;

public class VehicleListFactory {

    public ArrayList<ITurbo> turboListCreator() {
        return new ArrayList<ITurbo>();
    }

    public ArrayList<IPlatform> platformListCreator() {
        return new ArrayList<IPlatform>();
    }

    public ArrayList<IRamp> rampListCreator() {
        return new ArrayList<IRamp>();
    }

}
