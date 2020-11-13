import java.awt.*;

public class Scania extends Truck {
    /**
     * The angle of the platform
     */
    private double platform;

    /**
     * Constructs a Scania object
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
     */
    public Scania (int nrDoors, Color color, double enginePower, String modelName) {
        super(2, Color.yellow, 900, "Scania");
        setPlatform(0);
    }

    public void setPlatform(double platform) {
        this.platform = platform;
    }

    public double getPlatform(double platform) {
        return platform;
    }
}
