package ua.lviv.iot.algo.part1.lab2;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Stadium extends AbstractStadium{
    final static int ONE_HUNDRED_PEOPLE_TO_EXPEL = 100;
    private String homeTeam;
    private String awayTeam;
    public Stadium(String name, int capacity, int currentAttendance, String homeTeam, String awayTeam) {
        super(name, capacity, currentAttendance);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void addAttendies(int count) {
        var newAttendance = currentAttendance + count;
        if (newAttendance > capacity) {
            System.out.println("The stadium is full!");
            return;
        }
        currentAttendance = newAttendance;
    }

    public void decreaseAttendance() {
        if (currentAttendance >= ONE_HUNDRED_PEOPLE_TO_EXPEL) {
            currentAttendance -= ONE_HUNDRED_PEOPLE_TO_EXPEL;
        } else {
            System.out.println("There is no attendees left to remove!");
        }
    }

    @Override
    public List<String> getSupportedSports() {
        return List.of("Football", "Basketball", "Tennis");
    }
}