package ua.lviv.iot.algo.part1.lab3;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractStadium {
    private String name;
    protected int capacity;
    protected int currentAttendance;

    public abstract List<String> getSupportedSports();
}
