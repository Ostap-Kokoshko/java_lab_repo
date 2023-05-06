package ua.lviv.iot.algo.part1.lab3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class SkatingRink extends AbstractStadium {
    private final static String HEADERS = ",hasNaturalIce,areaInSquareMeters";
    private boolean hasNaturalIce;
    private int areaInSquareMeters;

    public SkatingRink(final String name,
                       final int capacity,
                       final int currentAttendance,
                       final boolean hasNaturalIce,
                       final int areaInSquareMeters) {
        super(name, capacity, currentAttendance);
        this.hasNaturalIce = hasNaturalIce;
        this.areaInSquareMeters = areaInSquareMeters;
    }

    @Override
    public final List<String> getSupportedSports() {
        return List.of("Hockey", "Figure skating");
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + HEADERS;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hasNaturalIce + "," + areaInSquareMeters;
    }
}
