package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class SkiResort extends AbstractStadium {
    private double descentLength;
    private int slopeSteepnessInDegrees;

    public SkiResort(final String name,
                     final int capacity,
                     final int currentAttendance,
                     final double descentLength,
                     final int slopeSteepnessInDegrees) {
        super(name, capacity, currentAttendance);
        this.descentLength = descentLength;
        this.slopeSteepnessInDegrees = slopeSteepnessInDegrees;
    }

    @Override
    public final List<String> getSupportedSports() {
        return List.of("Ski racing", "Biathlon", "FreeStyle", "Ski dueling", "Ski jumping");
    }
}
