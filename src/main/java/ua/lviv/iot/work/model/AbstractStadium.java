package ua.lviv.iot.work.model;

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
    private final static String HEADERS = "name,capacity,currentAttendance";
    private String name;
    protected int capacity;
    protected int currentAttendance;

    public abstract List<String> getSupportedSports();

    public String getHeaders() {
        return HEADERS;
    }

    public String toCSV() {
        return name + "," + capacity + "," + currentAttendance;
    }
}
