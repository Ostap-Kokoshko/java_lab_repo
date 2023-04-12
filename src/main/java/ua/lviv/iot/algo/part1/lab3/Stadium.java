package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Stadium extends AbstractStadium {
    final static int PEOPLE_TO_EXPEL = 100;
    private String homeTeam;
    private String awayTeam;

    public Stadium(final String name,
                   final int capacity,
                   final int currentAttendance,
                   final String homeTeam,
                   final String awayTeam) {
        super(name, capacity, currentAttendance);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void addAttendies(int count) {
        var newAttendance = currentAttendance + count;
        if (newAttendance > capacity) {
            System.out.println("The stadium is full!");
        } else {
            System.out.println("I am addind attendance");
            currentAttendance = newAttendance;
        }
    }

    public void decreaseAttendance() {
        if (currentAttendance >= PEOPLE_TO_EXPEL) {
            currentAttendance -= PEOPLE_TO_EXPEL;
        } else {
            System.out.println("There is no attendees left to remove!");
        }
    }

    @Override
    public final List<String> getSupportedSports() {
        return List.of("Football", "Basketball", "Tennis");
    }
}