package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class StadiumWriterTest {
    private StadiumWriter writer;
    private static final String RESULT_FILENAME = "result.csv";
    private static final String EXPECTED_FILENAME = "expected.csv";
    private List<AbstractStadium> stadiums;
    private File resultFile;
    private final File expectedFile = new File(EXPECTED_FILENAME);
    @BeforeEach
    public void setUp() throws IOException {
        writer = new StadiumWriter();

        Files.deleteIfExists(Path.of(RESULT_FILENAME));

        resultFile = new File(RESULT_FILENAME);

        stadiums = new LinkedList<>();
        stadiums.add(new Stadium("Arena Lviv", 30000, 13000, "Shahtar", "Carpatian"));
        stadiums.add(new Stadium("Olymp", 40000, 11000, "Ukraine", "Spain"));
        stadiums.add(new SwimmingPool("SKA", 44000, 1000, 10, 3000, 2000));
        stadiums.add(new SwimmingPool("Kiyv", 50000, 1300, 12, 1500, 4000));
        stadiums.add(new SkiResort("Bukovel", 9000, 300, 500.5, 30));
        stadiums.add(new SkiResort("Italy", 10000, 300, 325.5, 25));
        stadiums.add(new SkatingRink("Ternopil", 10000, 5000, true, 400));
        stadiums.add(new SkatingRink("Odesa", 12000, 3000, false, 500));
    }

    @AfterEach
    public void tearDown() throws IOException{
        Files.deleteIfExists(Path.of(RESULT_FILENAME));
    }

    @Test
    public void testEmptyWrite() {
        writer.writeToFile(null);
        Assertions.assertFalse(resultFile.exists());
    }

    @Test
    public void testWriteListOfStadiums() throws IOException {
        writer.writeToFile(stadiums);
        Path actual = resultFile.toPath();
        Path expected = expectedFile.toPath();
        Assertions.assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testFileOverride() throws IOException {
        FileWriter fileWriter = new FileWriter(resultFile);
        fileWriter.write("Hi");
        fileWriter.close();
        testWriteListOfStadiums();
    }
}
