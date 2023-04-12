package ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class StadiumManager {
    private final List<AbstractStadium> stadiums = new LinkedList<>();

    public void addStadium(final AbstractStadium stadium) {
        this.stadiums.add(stadium);
    }

    public List<AbstractStadium> findStadiumWithCapacity(final int capacity) {
        return stadiums.stream().
                filter(stadium -> stadium.getCapacity() == capacity).
                collect(Collectors.toList());
    }

    public List<AbstractStadium> findStadiumWithMoreAttendanceNowThan(final int currentAttendance) {
        return stadiums.stream().
                filter(stadium -> stadium.getCurrentAttendance() > currentAttendance).
                collect(Collectors.toList());
    }
}
