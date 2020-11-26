import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Platform should be set to 70 if given a value greater than 70
 * Platform should be set to 0 if given a value less than 0
 * Scania should throw exception when trying to move while platform is not 0
 * Scania should move when flatbed is down
 * Should throw exception when trying to set platform while it has speed i.e. is moving
 */
public class ScaniaTests {
    @Test
    public void raiseMoreThan70() {
        Scania truck = new Scania(Direction.EAST, 0, 0);
        truck.setPlatform(76);
        assertEquals(70, truck.getPlatform(), 0);
    }

    @Test
    public void lowerLessThanZero() {
        Scania truck = new Scania(Direction.EAST, 0, 0);
        truck.setPlatform(-12);
        assertEquals(0, truck.getPlatform(), 0);
    }

    @Test
    public void cantMoveWhenFlatbedIsUp() {
        Scania scania = new Scania(Direction.EAST, 0, 0);
        scania.setPlatform(50);
        scania.setCurrentSpeed(20);
        assertThrows(IllegalArgumentException.class, () -> {
            scania.move();
        });
    }

    @Test
    public void canMoveWhenFlatbedIsDown() {
        Scania scania = new Scania(Direction.EAST, 0, 0);
        scania.setPlatform(0);
        scania.startEngine();
        scania.setFacing(Direction.EAST);
        scania.setX(0);
        scania.setY(0);
        scania.gas(0.2);
        scania.move();
        assertTrue(scania.getX() > 0);
    }

    @Test
    public void cantChangePlatformWhileHavingSpeed() {
        Scania truck = new Scania(Direction.EAST, 0, 0);
        truck.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            truck.setPlatform(5);
        });
    }



}
