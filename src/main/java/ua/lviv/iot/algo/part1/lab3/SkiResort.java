package ua.lviv.iot.algo.part1.lab3;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class SkiResort extends AbstractStadium {
    private double descentLength;
    private int slopeSteepnessInDegrees;

    public SkiResort(String name, int capacity, int currentAttendance,
                     double descentLength, int slopeSteepnessInDegrees) {
        super(name, capacity, currentAttendance);
        this.descentLength = descentLength;
        this.slopeSteepnessInDegrees = slopeSteepnessInDegrees;
    }

    @Override
    public List<String> getSupportedSports() {
        return List.of("Ski racing", "Biathlon", "FreeStyle", "Ski dueling", "Ski jumping");
    }
}
