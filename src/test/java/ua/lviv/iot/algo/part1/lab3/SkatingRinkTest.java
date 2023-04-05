package ua.lviv.iot.algo.part1.lab3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SkatingRinkTest {
    private final SkatingRink stadium = new SkatingRink("Odesa", 12000, 3000, false, 500);
    private final SkatingRink stadium2 = new SkatingRink("Odesa", 12000, 3000, false, 500);
    private final SkatingRink stadium3 = new SkatingRink();

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Hockey", "Figure skating"), stadium.getSupportedSports());
    }

    @Test
    public void testHasNaturalIce(){
        stadium.setHasNaturalIce(false);
        assertEquals(stadium2.toString(), stadium.toString());
    }

    @Test
    public void testAreaInSquareMeters(){
        assertEquals(500, stadium.getAreaInSquareMeters());
    }
}
