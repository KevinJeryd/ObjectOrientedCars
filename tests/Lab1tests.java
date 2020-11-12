import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Current speed after stopping engine should be 0
 * Current speed after starting engine should be greater than zero
 * Speed should be higher after incrementSpeed
 * Speed should be lower after decrementSpeed
 * Car should have new values for y after move method while facing NORTH
 * Car should have new values for x after move method while facing EAST
 * Car should face SOUTH after turning left from WEST
 * Car should face NORTH after turning right from WEST
 * Should throw exception if gas amount is greater than one
 * Speed should increase if gas with legal amount
 * Should throw exception if brake amount is smaller than zero
 * Speed should decrease if brake with legal amount
 * Speed factor for Volvo240 should take into account the trim factor
 * isTurboOn should be true if setTurboOn is called
 * isTurboOn should be false if setTurboOff is called.
 * Color of car should now be gray
 * Volvo240 should have 4 doors
 * Turning four times anti clockwise should make the car face the same direction it started with
 * Turning four times clockwise should make the car face the same direction it started with
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
    public void moveMovesTheCarNorth() {
        Car car = new Saab95();
        car.startEngine();
        car.setFacing(Car.Direction.NORTH);
        car.setX(0);
        car.setY(0);
        car.move();
        assertTrue(car.getY() > 0);
    }

    @Test
    public void moveMovesTheCarEast() {
        Car car = new Saab95();
        car.startEngine();
        car.setFacing(Car.Direction.EAST);
        car.setX(0);
        car.setY(0);
        car.move();
        assertTrue(car.getX() > 0);
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
    public void gasWithOkayAmount() {
        Car car = new Saab95();
        car.gas(0.4);
        assertTrue(car.getCurrentSpeed() > 0);

    }

    @Test
    public void brakeWithLowerThanZero() {
        Car car = new Saab95();
        assertThrows(IllegalArgumentException.class, () -> {
            car.brake(-3);
        });
    }

    @Test
    public void brakeWithOkayAmount() {
        Car car = new Saab95();
        car.startEngine();
        car.brake(0.8);
        assertTrue(car.getCurrentSpeed() == 0);
    }

    @Test
    public void volvoSpeedFactor() {
        Car car = new Volvo240();
        double speedFactor = car.speedFactor();
        assertEquals(1.25, speedFactor, 0);
    }


    @Test
    public void TurboOnSetsTurboOn() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        assertTrue (car.isTurboOn());
    }

    @Test
    public void TurboOffSetsTurboOff() {
       Saab95 car = new Saab95();
       car.setTurboOff();
       assertFalse(car.isTurboOn());
    }

    @Test
    public void changeColor() {
        Car car = new Volvo240();
        car.setColor(Color.gray);
        assertEquals(Color.gray, car.getColor());
    }

    @Test
    public void checkNrDoors() {
        Car car = new Volvo240();
        assertEquals(4, car.getNrDoors());
    }

    @Test
    public void carGoAroundAntiClockwise() {
        Car car = new Saab95();
        car.startEngine();
        car.setFacing(Car.Direction.NORTH);
        car.setY(0);
        car.setX(0);
        for (int i = 0; i < 8; i++) {
            car.move();
            car.turnLeft();
        }

        assertEquals(Car.Direction.NORTH, car.getFacing());
    }

    @Test
    public void carGoAroundClockwise() {
        Car car = new Saab95();
        car.startEngine();
        car.setFacing(Car.Direction.NORTH);
        car.setY(0);
        car.setX(0);
        for (int i = 0; i < 8; i++) {
            car.move();
            car.turnRight();
        }

        assertEquals(Car.Direction.NORTH, car.getFacing());
    }


}
