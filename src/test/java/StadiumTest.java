import ua.lviv.iot.algo.part1.lab3.Stadium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class StadiumTest extends Stadium {
    Stadium stadium = new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian");

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Football", "Basketball", "Tennis"), stadium.getSupportedSports());
    }
}
