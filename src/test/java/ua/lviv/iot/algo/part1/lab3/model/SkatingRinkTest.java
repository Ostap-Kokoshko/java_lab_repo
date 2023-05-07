package ua.lviv.iot.algo.part1.lab3.model;

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
        assertEquals(stadium2.toString(), stadium.toString());
    }

    @Test
    public void testAreaInSquareMeters(){
        assertEquals(500, stadium.getAreaInSquareMeters());
    }

    @Test
    public void testHeaders() {
        SkatingRink stadiium = new SkatingRink("Ternopil", 10000, 5000, true, 400);
        assertEquals("name,capacity,currentAttendance,hasNaturalIce,areaInSquareMeters", stadiium.getHeaders());
    }

    @Test
    public void testToCsv() {
        SkatingRink stadiium = new SkatingRink("Ternopil", 10000, 5000, true, 400);
        assertEquals("Ternopil,10000,5000,true,400", stadiium.toCSV());
    }
}
