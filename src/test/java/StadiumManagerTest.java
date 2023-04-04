import ua.lviv.iot.algo.part1.lab3.StadiumManager;
import ua.lviv.iot.algo.part1.lab3.SkatingRink;
import ua.lviv.iot.algo.part1.lab3.SwimmingPool;
import ua.lviv.iot.algo.part1.lab3.Stadium;
import ua.lviv.iot.algo.part1.lab3.SkiResort;
import ua.lviv.iot.algo.part1.lab3.AbstractStadium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StadiumManagerTest {
    @Test
    public void testAddStadium() {
        StadiumManager stadiumManager = new StadiumManager();
        stadiumManager.addStadium(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiumManager.addStadium(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiumManager.addStadium(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiumManager.addStadium(new SwimmingPool("Kiyv", 50000, 1300, 12, 1500, 4000));
        stadiumManager.addStadium(new SkiResort("Bukovel", 9000, 300, 500.5, 30));
        stadiumManager.addStadium(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiumManager.addStadium(new SkatingRink("Ternopil", 10000, 5000, true, 400));
        stadiumManager.addStadium(new SkatingRink("Odesa", 12000, 3000, false, 500));

        assertEquals(8, stadiumManager.getStadiums().size());
    }

    @Test
    public void testFindStadiumWithCapacity() {
        List<AbstractStadium> stadiums = new LinkedList<>();
        stadiums.add(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiums.add(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiums.add(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiums.add(new SwimmingPool("Kiyv", 50000, 1300, 12, 1500, 4000));
        stadiums.add(new SkiResort("Bukovel", 9000, 300, 500.5, 30));
        stadiums.add(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));
        stadiums.add(new SkatingRink("Odesa", 12000, 3000, false, 500));

        List<AbstractStadium> stadiumNewList = stadiums.stream().
                filter(stadium -> stadium.getCapacity() == 10000).
                collect(Collectors.toList());

        List<AbstractStadium> actualStadiums = new LinkedList<>();
        actualStadiums.add(new SkiResort("Italy", 10000, 300, 325.5, 25));
        actualStadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));

        assertEquals(stadiumNewList.size(), actualStadiums.size());
    }

    @Test
    public void testFindStadiumWithMoreAttendanceNowThan() {
        List<AbstractStadium> stadiums = new LinkedList<>();
        stadiums.add(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiums.add(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiums.add(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiums.add(new SwimmingPool("Kiyv", 50000, 1300, 12, 1500, 4000));
        stadiums.add(new SkiResort("Bukovel", 9000, 300, 500.5, 30));
        stadiums.add(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));
        stadiums.add(new SkatingRink("Odesa", 12000, 3000, false, 500));

        List<AbstractStadium> stadiumNewList = stadiums.stream().
                filter(stadium -> stadium.getCurrentAttendance() > 4000).
                collect(Collectors.toList());

        List<AbstractStadium> actualStadiums = new LinkedList<>();
        actualStadiums.add(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        actualStadiums.add(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        actualStadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));

        assertEquals(stadiumNewList.size(), actualStadiums.size());
    }
}