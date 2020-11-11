import org.junit.Test;
import static  org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

/**
 * Current speed after stopping engine should be 0
 * Current speed after starting engine should be greater than zero
 * Speed should be higher after incrementSpeed
 * Speed should be lower after decrementSpeed
 * Car should have new values for y after move method while facing NORTH
 * Car should face SOUTH after turning left from WEST
 * Car should face NORTH after turning right from WEST
 * Should throw exception if gas amount is greater than one
 * Should throw exception if brake amount is smaller than zero
 */

public class Lab1tests {

    @Test
    public void stopMotorSpeedEqualZero() {
        Car car = new Saab95();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), 0);
    }

    @Test
    public void startMotorSpeedGreaterThanZero() {
        Car car = new Volvo240();
        car.startEngine();
        assertTrue(car.getCurrentSpeed() > 0);
    }

    @Test
    public void higherSpeedAfterIncrementSpeed() {
        Car car = new Saab95();
        double speedBeforeInc = car.getCurrentSpeed();
        car.incrementSpeed(3);
        double speedAfterInc = car.getCurrentSpeed();
        assertTrue(speedAfterInc > speedBeforeInc);
    }

    @Test
    public void lowerSpeedAfterDecrementSpeed() {
        Car car = new Saab95();
        car.startEngine();
        double speedBeforeDec = car.getCurrentSpeed();
        car.decrementSpeed(3);
        double speedAfterDec = car.getCurrentSpeed();
        assertTrue(speedAfterDec < speedBeforeDec);
    }

    @Test
    public void moveMovesTheCar() {
        Car car = new Saab95();
        car.startEngine();
        car.setFacing(Car.Direction.NORTH);
        car.setX(0);
        car.setY(0);
        car.move();
        assertTrue(car.getY() > 0);
    }

    @Test
    public void turnLeftTurnsLeft () {
        Car car = new Volvo240();
        car.setFacing(Car.Direction.WEST);
        car.turnLeft();
        assertTrue( car.getFacing() == Car.Direction.SOUTH );
    }

    @Test
    public void turnRightTurnsRight () {
        Car car = new Volvo240();
        car.setFacing(Car.Direction.WEST);
        car.turnRight();
        assertTrue( car.getFacing() == Car.Direction.NORTH );
    }

    @Test
    public void gasWithHigherThanOne() {
        Car car = new Saab95();
        assertThrows(IllegalArgumentException.class, () -> {
            car.gas(32);
        });
    }

    @Test
    public void brakeWithLowerThanZero() {
        Car car = new Saab95();
        assertThrows(IllegalArgumentException.class, () -> {
            car.brake(-3);
        });
    }

}
