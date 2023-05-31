package src.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SeatingArrangementServiceTest {
    @Test
    public void should_printOptimalSeating_when_printOptimalSeatingArrangement_dataInput() {
        String expectedResult = "Optimal seating arrangement: [Bob, Alice, George, David, Frank, Carol, Eric, Mallory]\r\n" +
            "Total change in happiness: 709";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        SeatingArrangementService.printOptimalSeatingArrangement("data/data.txt");

        System.setOut(System.out);

        String result = outputStream.toString().trim();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void should_printOptimalSeating_when_printOptimalSeatingArrangement_testDataInput() {
        String expectedResult = "Optimal seating arrangement: [Bob, Alice, David, Carol]\r\n" +
                "Total change in happiness: 330";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        SeatingArrangementService.printOptimalSeatingArrangement("data/testData.txt");

        System.setOut(System.out);

        String result = outputStream.toString().trim();

        Assertions.assertEquals(expectedResult, result);
    }

}