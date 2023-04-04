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
public class SwimmingPool extends AbstractStadium{
    private int numberOfBathrooms;
    private double volume;
    private int maxNumberOfVisitors;

    public SwimmingPool(String name, int capacity, int currentAttendance, int numberOfBathrooms,
                        double volume, int maxNumberOfVisitors) {
        super(name, capacity, currentAttendance);
        this.numberOfBathrooms = numberOfBathrooms;
        this.volume = volume;
        this.maxNumberOfVisitors = maxNumberOfVisitors;
    }

    @Override
    public List<String> getSupportedSports() {
        return List.of("Swimming", "Water Polo");
    }
}
