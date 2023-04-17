package ua.lviv.iot.algo.part1.lab3;

import lombok.Generated;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class StadiumWriter {
    String csvFileName = "result.csv";

    // When it`s already sorted list
    public String writeToFile(final List<AbstractStadium> stadiums) {
        if (stadiums == null || stadiums.isEmpty()) {
            return null;
        }
        try (FileWriter writer = new FileWriter(csvFileName)) {
            AbstractStadium stadiumType = stadiums.get(0);
            writer.write(stadiums.get(0).getHeaders());
            writer.write("\n");
            for (AbstractStadium stadium : stadiums) {
                if (stadiumType.getClass() != stadium.getClass()) {
                    stadiumType = stadium;
                    writer.write(stadium.getHeaders());
                    writer.write("\r\n");
                }
                writer.write(stadium.toCSV());
                writer.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvFileName;
    }

    //When it`s not sorted list
    @Generated
    public String writeNotSortedListToFile(List<AbstractStadium> stadiums) {
        Map<String, List<AbstractStadium>> sortedStadiums = new HashMap<>();

        String stadiumKey = Stadium.class.toString();
        String swimmingPoolKey = SwimmingPool.class.toString();
        String skiResortKey = SkiResort.class.toString();
        String skatingRinkKey = SkatingRink.class.toString();

        sortedStadiums.put(stadiumKey, new LinkedList<>());
        sortedStadiums.put(swimmingPoolKey, new LinkedList<>());
        sortedStadiums.put(skiResortKey, new LinkedList<>());
        sortedStadiums.put(skatingRinkKey, new LinkedList<>());

        if (stadiums == null || stadiums.isEmpty()) {
            return null;
        }
        try (FileWriter writer = new FileWriter(csvFileName)) {
            List<String> keys = new ArrayList<>(Arrays
                    .asList(stadiumKey, swimmingPoolKey, skiResortKey, skatingRinkKey));
            for (AbstractStadium stadium : stadiums) {
                for (String key : keys) {
                    if (stadium.getClass().toString().equals(key)) {
                        sortedStadiums.get(key).add(stadium);
                    }
                }
            }
            for (String key : keys) {
                writer.write(sortedStadiums.get(key).get(1).getHeaders());
                writer.write(System.lineSeparator());
                for (int i = 0; i < sortedStadiums.get(key).size(); i++) {
                    writer.write(sortedStadiums.get(key).get(i).toCSV());
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvFileName;
    }
}
