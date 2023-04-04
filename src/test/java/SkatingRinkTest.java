import ua.lviv.iot.algo.part1.lab3.SkatingRink;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SkatingRinkTest extends SkatingRink {
    SkatingRink stadium = new SkatingRink("Odesa", 12000, 3000, false, 500);

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Hockey", "Figure skating"), stadium.getSupportedSports());
    }
}
