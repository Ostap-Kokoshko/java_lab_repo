package ua.lviv.iot.work.writer;

import ua.lviv.iot.work.model.AbstractStadium;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class StadiumWriter {
    public void writeToFile(final List<AbstractStadium> stadiums, String fileForList) {
        if (stadiums == null || stadiums.isEmpty()) {
            return;
        }
        try (FileWriter writer = new FileWriter(fileForList, StandardCharsets.UTF_8)) {
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
    }

    public void writeSortedStadium(List<AbstractStadium> stadiums, String fileForSortedList) {
        Collections.sort(stadiums, Comparator.comparing(stadium -> stadium.getClass().getName()));
        writeToFile(stadiums, fileForSortedList);
    }
}
