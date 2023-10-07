import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void testConstructorAndGetters() {
        Vehicle vehicle = new Vehicle("Toyota", 100);
        assertEquals("Toyota", vehicle.getBrand());
        assertEquals(100, vehicle.getSpeed());
        assertEquals(0, vehicle.getDistanceTraveled());
    }

    @Test
    public void testUpdateDistance() {
        Vehicle vehicle = new Vehicle("Toyota", 100);
        vehicle.updateDistance(50);
        assertEquals(50, vehicle.getDistanceTraveled());
    }
}
