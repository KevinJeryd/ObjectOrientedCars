import java.awt.*;

/**
 * Represents a Volvo240 extending the class Car.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public class Volvo240 extends Car{

    /**
     * double trimFactor; - the trim factor.
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Volvo240 object.
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}
