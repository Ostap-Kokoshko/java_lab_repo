package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class SwimmingPool extends AbstractStadium {
    private final static String HEADERS = ",numberOfBathrooms,volume,maxNumberOfVisitors";
    private int numberOfBathrooms;
    private double volume;
    private int maxNumberOfVisitors;

    public SwimmingPool(final String name,
                        final int capacity,
                        final int currentAttendance,
                        final int numberOfBathrooms,
                        final double volume,
                        final int maxNumberOfVisitors) {
        super(name, capacity, currentAttendance);
        this.numberOfBathrooms = numberOfBathrooms;
        this.volume = volume;
        this.maxNumberOfVisitors = maxNumberOfVisitors;
    }

    @Override
    public final List<String> getSupportedSports() {
        return List.of("Swimming", "Water Polo");
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + HEADERS;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + numberOfBathrooms + "," + volume + "," + maxNumberOfVisitors;
    }
}
