package src.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataRepositoryImpl implements DataRepository{

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Map<String, Integer>> getAll(String datafile) {
        Map<String, Map<String, Integer>> guestList = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(datafile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                String guest = split[0];
                int happiness = split[2].equals("gain") ? Integer.parseInt(split[3]) : Integer.parseInt("-" + split[3]);
                String neighbour = split[10].replace(".", "");
                guestList.putIfAbsent(guest, new HashMap<>());
                guestList.get(guest).put(neighbour, happiness);
            }
        } catch (IOException e) {
            System.err.println("Error med filen: " + e.getMessage());
        }
        return guestList;
    }
}
