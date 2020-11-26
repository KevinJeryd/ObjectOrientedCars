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
    public Volvo240(Direction facing, double x, double y){
        super(4, Color.black, 100, "Volvo240", facing, x, y);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
