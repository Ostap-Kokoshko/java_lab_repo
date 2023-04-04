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
public class SkatingRink extends AbstractStadium {
    private boolean hasNaturalIce;
    private int areaInSquareMeters;

    public SkatingRink(String name, int capacity, int currentAttendance,
                       boolean hasNaturalIce, int areaInSquareMeters) {
        super(name, capacity, currentAttendance);
        this.hasNaturalIce = hasNaturalIce;
        this.areaInSquareMeters = areaInSquareMeters;
    }

    @Override
    public List<String> getSupportedSports() {
        return List.of("Hockey", "Figure skating");
    }
}
