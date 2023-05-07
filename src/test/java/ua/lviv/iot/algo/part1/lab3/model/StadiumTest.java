package ua.lviv.iot.algo.part1.lab3.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class StadiumTest {
    private final Stadium stadium = new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian");
    private final Stadium stadium2 = new Stadium("Arena Lviv", 30000, 1000, "Shahtar", "Carpatian");
    private final Stadium stadium3 = new Stadium();

    @Test
    public void testGetSupportedSports() {
        assertEquals(List.of("Football", "Basketball", "Tennis"), stadium.getSupportedSports());
    }

    @Test
    public void testAddAttendies() {
        stadium.addAttendies(100);
        assertEquals(13100, stadium.getCurrentAttendance());
        stadium.setCurrentAttendance(1000);
        assertEquals(stadium2.toString(), stadium.toString());

        stadium.addAttendies(30000);
        assertEquals(1000, stadium.getCurrentAttendance());
    }

    @Test
    public void testDecreaseAttendance() {
        stadium.decreaseAttendance();
        assertEquals(12900, stadium.getCurrentAttendance());
        stadium.setCurrentAttendance(1);
        stadium.decreaseAttendance();
        assertEquals(1, stadium.getCurrentAttendance());
    }

    @Test
    public void testHeaders() {
        Stadium stadiium = new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian");
        assertEquals("name,capacity,currentAttendance,homeTeam,awayTeam", stadiium.getHeaders());
    }

    @Test
    public void testToCsv() {
        Stadium stadiium = new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian");
        assertEquals("Arena Lviv,30000,13000,Shahtar,Carpatian", stadiium.toCSV());
    }
}
