package ua.lviv.iot.algo.part1.lab3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SwimmingPoolTest {
    private final SwimmingPool stadium = new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000);
    private final SwimmingPool stadium2 = new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000);
    private final SwimmingPool stadium3 = new SwimmingPool();

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Swimming", "Water Polo"), stadium.getSupportedSports());
    }

    @Test
    public void testNumberOfBathrooms(){
        assertEquals(stadium2.toString(), stadium.toString());
    }

    @Test
    public void testVolume() {
        assertEquals(3000, stadium.getVolume(), 10);
    }

    @Test
    public void testMaxNumberOfVisitors() {
        assertEquals(2000, stadium.getMaxNumberOfVisitors());
    }

    @Test
    public void testHeaders() {
        SwimmingPool stadiium = new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000);
        assertEquals("name,capacity,currentAttendance,numberOfBathrooms,volume,maxNumberOfVisitors", stadiium.getHeaders());
    }

    @Test
    public void testToCsv() {
        SwimmingPool stadiium = new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000);
        assertEquals("SKA,44000,1000,10,3000.0,2000", stadiium.toCSV());
    }
}