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

    /**
     * Sets platform angle (only between 0 and 70) and not while in motion.
     *
     * @param platform
     */
    public void setPlatform(double platform) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("You can't drive and change the platform!");
        } else {
            if (getPlatform() < 0) {
                this.platform = 0;
            } else if (getPlatform() > 70) {
                this.platform = 70;
            } else {
                this.platform = platform;
            }
        }
    }

    public double getPlatform() {
        return platform;
    }

    @Override
    public void move(){
        if (getPlatform() == 0) {
            super.move();
        } else {
            throw new IllegalArgumentException("Lower the platform first!");
        }
    }
}
