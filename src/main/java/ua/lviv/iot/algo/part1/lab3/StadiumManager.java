package ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Generated;
import lombok.Getter;

@Getter
public class StadiumManager {
    private final List<AbstractStadium> stadiums = new LinkedList<>();
    private static final String csvFileName = "result.csv";
    private static final String sortedCsvFileName = "sortedresult.csv";

    public void addStadium(final AbstractStadium stadium) {
        this.stadiums.add(stadium);
    }

    public List<AbstractStadium> findStadiumWithCapacity(final int capacity) {
        return stadiums
                .stream()
                .filter(stadium -> stadium.getCapacity() == capacity)
                .collect(Collectors.toList());
    }

    public List<AbstractStadium> findStadiumWithMoreAttendanceNowThan(final int currentAttendance) {
        return stadiums
                .stream()
                .filter(stadium -> stadium.getCurrentAttendance() > currentAttendance)
                .collect(Collectors.toList());
    }

    @Generated
    public static void main(String[] args) {
        List<AbstractStadium> stadiumManager = new LinkedList<>();
        stadiumManager.add(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiumManager.add(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiumManager.add(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiumManager.add(new SwimmingPool("Kiyv", 50000, 1300, 12, 1500, 4000));
        stadiumManager.add(new SkiResort("Bukovel", 9000, 300, 500.5, 30));
        stadiumManager.add(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiumManager.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));
        stadiumManager.add(new SkatingRink("Odesa", 12000, 3000, false, 500));

        StadiumWriter writer = new StadiumWriter();
        writer.writeToFile(stadiumManager, csvFileName);
        writer.sortedStadium(stadiumManager, sortedCsvFileName);
    }
}
