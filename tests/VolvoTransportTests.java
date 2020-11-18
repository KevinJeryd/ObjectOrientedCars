import org.junit.Test;

import javax.sound.midi.VoiceStatus;
import java.awt.*;

import static org.junit.Assert.*;

/**
 * Ramp should be down when ramp is lowered
 * Ramp should be up when ramp is raised
 * Cars on transport should share position with transport after having been moved
 * Transport should not be allowed to move when ramp is down, exception should be thrown
 * Car should not be able to be loaded onto truck if not within proximity, exception should be thrown
 * Position of car should not be the same as transport after being unloaded
 * Exception should be thrown when trying to unload a car from transport when car stack is empty
 * Exception should be thrown when trying to load a fifth car onto transport
 * Ramp should not be allowed to be lowered while transport has speed i.e. is moving
 * Last car to be loaded onto transport should be the first one to be unloaded
 */
public class VolvoTransportTests {
    @Test
    public void lowersTheRamp() {
        VolvoTransport transport = new VolvoTransport();
        transport.lowerRamp();
        assertEquals(false, transport.isRampUp());

    }

    @Test
    public void raisesTheRamp() {
        VolvoTransport transport = new VolvoTransport();
        transport.lowerRamp();
        transport.raiseRamp();
        assertEquals(true, transport.isRampUp());
    }

    @Test
    public void moveMovesLoadedCars() {
        VolvoTransport transport = new VolvoTransport();
        transport.setX(0);
        transport.setY(0);

        Car car = new Volvo240();
        car.setX(0.5);
        car.setY(0.5);

        transport.loadCar(car);
        transport.startEngine();
        transport.setCurrentSpeed(10);
        transport.raiseRamp();
        transport.move();

        double carXAfterMove = transport.getCarStack().get(0).getX();
        double carYAfterMove = transport.getCarStack().get(0).getY();

        assertTrue(carXAfterMove == transport.getX() && carYAfterMove == transport.getY());
    }

    @Test
    public void cantMoveWhenRampIsDown() {
        VolvoTransport transport = new VolvoTransport();
        transport.setX(0);
        transport.setY(0);

        Car car = new Volvo240();
        car.setX(0.5);
        car.setY(0.5);

        transport.loadCar(car);
        transport.startEngine();
        transport.setCurrentSpeed(10);

        assertThrows(IllegalArgumentException.class, () -> {
            transport.move();
        });
    }

    @Test
    public void carNotNearby() {
        VolvoTransport transport = new VolvoTransport();
        transport.setX(0);
        transport.setY(0);
        Car car = new Volvo240();
        car.setX(2);
        car.setY(0);
        assertThrows(IllegalArgumentException.class, () -> {
            transport.loadCar(car);
        });
    }

    @Test
    public void unloadCar() {
        VolvoTransport transport = new VolvoTransport();
        transport.setX(0);
        transport.setY(0);

        Car car = new Volvo240();
        car.setX(0.5);
        car.setY(0.5);

        transport.loadCar(car);
        transport.startEngine();
        transport.setCurrentSpeed(10);
        transport.raiseRamp();
        transport.move();
        transport.stopEngine();
        car = transport.unloadCar();
        assertTrue(car.getX() == transport.getX() -1);
    }

    @Test
    public void cantUnloadWhenStackEmpty() {
        VolvoTransport transport = new VolvoTransport();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            transport.unloadCar();
        });
    }

    @Test
    public void cantLoadWhenStackFull() {
        VolvoTransport transport = new VolvoTransport();
        Car car1 = new Volvo240();
        Car car2 = new Volvo240();
        Car car3 = new Saab95();
        Car car4 = new Saab95();
        Car carBroke = new Volvo240();

        transport.loadCar(car1);
        transport.loadCar(car2);
        transport.loadCar(car3);
        transport.loadCar(car4);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            transport.loadCar(carBroke);
        });
    }

    @Test
    public void cantLowerRampWhileDriving() {
        VolvoTransport transport = new VolvoTransport();
        transport.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            transport.lowerRamp();
        });
    }

    @Test
    public void sameCarWhenUnloaded() {
        VolvoTransport transport = new VolvoTransport();
        Car car1 = new Volvo240();
        Car car2 = new Volvo240();
        Car car3 = new Saab95();
        Car car4 = new Saab95();


        transport.loadCar(car1);
        transport.loadCar(car2);
        transport.loadCar(car3);
        transport.loadCar(car4);

        Car carAfterUnload = transport.unloadCar();
        assertEquals(carAfterUnload, car4);

    }

}
