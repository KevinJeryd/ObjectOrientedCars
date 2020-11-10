import org.junit.Test;
import static  org.junit.Assert.assertEquals;

/**
 * Current speed after stopping engine should be 0
 * Speed should be higher after incrementSpeed
 * Speed should be lower after decrementSpeed
 *
 *
 */

public class Lab1tests {

    @Test
    public void stopMotorSpeedEqualZero() {
        Car car = new Saab95();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), 0);
    }

    @Test
    public void higherSpeedAfterIncrementSpeed() {
        Car car = new Saab95();
        double speedBeforeInc = car.getCurrentSpeed();
        car.incrementSpeed(3);
        double speedAfterInc = car.getCurrentSpeed();
        assert (speedAfterInc > speedBeforeInc);
    }

    @Test
    public void lowerSpeedAfterDecrementSpeed() {
        Car car = new Saab95();
        double speedBeforeInc = car.getCurrentSpeed();
        car.decrementSpeed(3);
        double speedAfterInc = car.getCurrentSpeed();
        assert (speedAfterInc < speedBeforeInc);
    }

}
