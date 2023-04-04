import ua.lviv.iot.algo.part1.lab3.SwimmingPool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class SwimmingPoolTest extends SwimmingPool {
    SwimmingPool stadium = new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000);

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Swimming", "Water Polo"), stadium.getSupportedSports());
    }
}