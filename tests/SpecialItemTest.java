import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpecialItemTest {

    @Test
    public void testConstructorAndGetters() {
        SpecialItem item = new SpecialItem("Green Shell", 7, ConsoleColors.RED);
        assertEquals("Green Shell", item.getItem());
        assertEquals(7, item.getDelay());
        assertEquals(ConsoleColors.RED, item.getTextColor());
    }
}
