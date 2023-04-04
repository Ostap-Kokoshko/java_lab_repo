import ua.lviv.iot.algo.part1.lab3.SkiResort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SkiResortTest extends SkiResort {
    SkiResort stadium = new SkiResort("Bukovel", 9000, 300, 500.5, 30);

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Ski racing", "Biathlon", "FreeStyle", "Ski dueling", "Ski jumping"), stadium.getSupportedSports());
    }
}

