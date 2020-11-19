import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Should be able to unload any car
 * Should only be able to unload Volvo240's (since it's a volvo240 workshop)
 * Should not be able to unload if empty
 * Should not be able to load if full
 */
public class VehicleWorkshopTests {
    @Test
    public void unloadAnyCar() {
        VehicleWorkshop<Car> carWorkshop = new VehicleWorkshop<>(5);
        Car volvo = new Volvo240();
        Car saab = new Saab95();
        carWorkshop.load(volvo);
        carWorkshop.load(saab);
        Car volvoAfter = carWorkshop.unload(volvo);
        Car saabAfter = carWorkshop.unload(saab);
        assertTrue(volvoAfter.equals(volvo) && saabAfter.equals(saab));
    }

    @Test
    public void unloadOnlyVolvo240() {
        VehicleWorkshop<Volvo240> carWorkshop = new VehicleWorkshop<>(2);
        Volvo240 volvo = new Volvo240();
        carWorkshop.load(volvo);
        Volvo240 volvoAfter = carWorkshop.unload(volvo);
        assertEquals(volvoAfter, volvo);

    }

    @Test
    public void cantUnloadsIfEmpty() {
        VehicleWorkshop<Car> carWorkshop = new VehicleWorkshop<>(1);
        Car volvo = new Volvo240();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carWorkshop.unload(volvo);
        });
    }

    @Test
    public void cantLoadOverMaxCapacity() {
        VehicleWorkshop<Vehicle> workshop = new VehicleWorkshop<>(2);
        Vehicle volvoCar = new Volvo240();
        Vehicle volvoTruck = new VolvoTransport();
        Vehicle saab = new Saab95();
        workshop.load(volvoCar);
        workshop.load(volvoTruck);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            workshop.load(saab);
        });
    }
}
