import java.awt.*;

/**
 * Represents a Saab95 extending the class Car.
 * @author Gabriel Wadensten
 * @author Kevin Jeryd
 * @author Jonatan Sandgren
 */
public class Saab95 extends Car {

    /**
     * boolean turboOn; - Is the turbo on?
     */
    private boolean turboOn;

    /**
     * Constructs a Saab95 object.
     */
    public Saab95(Direction facing, double x, double y){
        super(2, Color.red, 125, "Saab95", facing, x, y);
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
