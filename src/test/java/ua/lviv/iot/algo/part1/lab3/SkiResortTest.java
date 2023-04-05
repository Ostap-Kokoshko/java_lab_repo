package ua.lviv.iot.algo.part1.lab3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SkiResortTest {
    private final SkiResort stadium = new SkiResort("Bukovel", 9000, 300, 500.5, 30);
    private final SkiResort stadium2 = new SkiResort("Bukovel", 9000, 300, 1000, 30);
    private final SkiResort stadium3 = new SkiResort();

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Ski racing", "Biathlon", "FreeStyle", "Ski dueling", "Ski jumping"), stadium.getSupportedSports());
    }

    @Test
    public void testDescentLength(){
        stadium.setDescentLength(1000);
        assertEquals(stadium2.toString(), stadium.toString());
    }

    @Test
    public void testSlopeSteepnessInDegrees() {
        assertEquals(30, stadium.getSlopeSteepnessInDegrees(), 0.5);
    }
}

