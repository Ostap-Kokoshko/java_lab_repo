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
        stadium.setNumberOfBathrooms(10);
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

}