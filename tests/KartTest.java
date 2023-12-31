import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class KartTest {

    @Test
    public void testAttack() {
        Kart kart = new Kart(100);
        int delay = kart.attack();
        assertTrue(delay >= 1 && delay <= 7);
    }

    @Test
    public void testDetailedAttack() {
        Kart kart = new Kart(100);
        SpecialItem item = kart.detailedAttack();
        assertNotNull(item);
    }
}
