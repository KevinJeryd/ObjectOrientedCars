import java.awt.*;
/**
 * Represents a Scania Truck extending the class Truck.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public class Scania extends Truck {
    /**
     * The angle of the platform
     */
    private double platform;

    /**
     * Constructs a Scania object
     */
    public Scania () {
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
            if (platform < 0) {
                this.platform = 0;
            } else if (platform > 70) {
                this.platform = 70;
            } else {
                this.platform = platform;
            }
        }
    }

    public double getPlatform() {
        return platform;
    }

    /**
     * Moves the vehicle in the direction the vehicle is facing.
     * Changes the x or y coordinates of the vehicle with the amount of current speed.
     * (Only when the platform is at zero)
     */
    @Override
    public void move(){
        if (getPlatform() == 0) {
            super.move();
        } else {
            throw new IllegalArgumentException("Lower the platform first!");
        }
    }
}
