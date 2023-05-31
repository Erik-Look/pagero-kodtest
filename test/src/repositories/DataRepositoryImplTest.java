package src.repositories;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DataRepositoryImplTest {
    private DataRepositoryImpl dataRepository;

    @Before
    public void setup() {
        dataRepository = new DataRepositoryImpl();
    }

    @Test
    public void should_populateGuestList_when_getAll_dataInput() {
        Map<String, Map<String, Integer>> result = dataRepository.getAll("data/data.txt");

        assertEquals(8, result.size());
        assertEquals(7, result.get("Bob").size());
        assertEquals(-95, result.get("Bob").get("George"));
    }

    @Test
    public void should_populateGuestList_when_getAll_testDataInput() {
        Map<String, Map<String, Integer>> result = dataRepository.getAll("data/testData.txt");

        assertEquals(4, result.size());
        assertEquals(3, result.get("Bob").size());
        assertEquals(83, result.get("Bob").get("Alice"));
    }
}