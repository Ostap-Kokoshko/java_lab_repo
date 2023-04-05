package ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Generated;
import lombok.Getter;

@Getter
public class StadiumManager {
    private final List<AbstractStadium> stadiums = new LinkedList<>();

    public void addStadium(AbstractStadium stadium){
        this.stadiums.add(stadium);
    }

    public List<AbstractStadium> findStadiumWithCapacity(int capacity) {
        return stadiums.stream().
                filter(stadium -> stadium.getCapacity() == capacity).
                collect(Collectors.toList());
    }

    public List<AbstractStadium> findStadiumWithMoreAttendanceNowThan(int currentAttendance){
        return stadiums.stream().
                filter(stadium -> stadium.getCurrentAttendance() > currentAttendance).
                collect(Collectors.toList());
    }
    @Generated
    public static void main(String[] args) {
        StadiumManager stadiumManager = new StadiumManager();
        stadiumManager.addStadium(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiumManager.addStadium(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiumManager.addStadium(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiumManager.addStadium(new SwimmingPool("Kiyv", 50000, 1300, 12, 1500, 4000));
        stadiumManager.addStadium(new SkiResort("Bukovel", 9000, 300, 500.5, 30));
        stadiumManager.addStadium(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiumManager.addStadium(new SkatingRink("Ternopil", 10000, 5000, true, 400));
        stadiumManager.addStadium(new SkatingRink("Odesa", 12000, 3000, false, 500));

        for (AbstractStadium stadium: stadiumManager.stadiums){
            System.out.println(stadium);
        }

        System.out.println("\n");

        var stadiumsWithCapacity = stadiumManager.findStadiumWithCapacity(10000);
        System.out.println("Stadiums with capacity ");
        for (AbstractStadium stadium: stadiumsWithCapacity){
            System.out.println(stadium);
        }

        System.out.println("\n");

        var stadiumsWithMoreAttendanceNowThan = stadiumManager.findStadiumWithMoreAttendanceNowThan(4000);
        for (AbstractStadium stadium: stadiumsWithMoreAttendanceNowThan){
            System.out.println(stadium);
        }
    }
}
