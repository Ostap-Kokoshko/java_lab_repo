package ua.lviv.iot.algo.part1.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class StadiumManagerTest {
    StadiumManager stadiumManager = new StadiumManager();

    @Test
    @DisplayName("Add Stadium method should work")
    public void testAddStadium() {
        for(int index = 0; index < 8; index++){
            stadiumManager.addStadium(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        }
        assertEquals(8, stadiumManager.getStadiums().size());
    }

    @Test
    @DisplayName("Find Stadium with some capacity should work")
    public void testFindStadiumWithCapacity() {
        stadiumManager.addStadium(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiumManager.addStadium(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiumManager.addStadium(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiumManager.addStadium(new SkatingRink("Ternopil", 10000, 5000, true, 400));

        List<AbstractStadium> actualStadiums = new LinkedList<>();
        actualStadiums.add(new SkiResort("Italy", 10000, 300, 325.5, 25));
        actualStadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));

        assertEquals(actualStadiums.size(), stadiumManager.findStadiumWithCapacity(10000).size());
    }

    @Test
    @DisplayName("Find Stadium with more attendance now than some number should work")
    public void testFindStadiumWithMoreAttendanceNowThan() {
        stadiumManager.addStadium(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiumManager.addStadium(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiumManager.addStadium(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiumManager.addStadium(new SkatingRink("Ternopil", 10000, 5000, true, 400));

        List<AbstractStadium> actualStadiums = new LinkedList<>();
        actualStadiums.add(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        actualStadiums.add(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        actualStadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));

        List<AbstractStadium> findCurrentAttendiesWorkWhenNull = stadiumManager.findStadiumWithMoreAttendanceNowThan(4000);
        assertFalse(findCurrentAttendiesWorkWhenNull.isEmpty());
        assertEquals(findCurrentAttendiesWorkWhenNull.size(), actualStadiums.size());

        assertEquals(actualStadiums.size(), stadiumManager.findStadiumWithMoreAttendanceNowThan(4000).size());
    }
}