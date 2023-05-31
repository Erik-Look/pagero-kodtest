package src.services;

import src.repositories.DataRepository;
import src.repositories.DataRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SeatingArrangementService {

    /**
     * Gets guestlist from datafile and prints the optimal seating arrangement.
     * @param datafile .
     */
    public static void printOptimalSeatingArrangement(String datafile) {
        DataRepository dataRepository = new DataRepositoryImpl();
        Map<String, Map<String, Integer>> guestList = dataRepository.getAll(datafile);

        List<List<String>> seatingArrangements = new ArrayList<>();
        generateAllSeatingArrangements(new ArrayList<>(guestList.keySet()), new ArrayList<>(), seatingArrangements);

        int totalChangeInHappiness = 0;
        List<String> optimalSeatingArrangement = new ArrayList<>();
        for (List<String> seatingArrangement : seatingArrangements) {
            int seatingArrangementHappiness = 0;
            for (int i = 0; i < seatingArrangement.size(); i++) {
                String guest = seatingArrangement.get(i);
                String neighbour1 = i == 0 ? seatingArrangement.get(seatingArrangement.size() - 1) : seatingArrangement.get(i - 1);
                String neighbour2 = i == seatingArrangement.size() - 1 ? seatingArrangement.get(0) : seatingArrangement.get(i + 1);
                Integer happinessFromNeighbour1 = guestList.get(guest).get(neighbour1);
                Integer happinessFromNeighbour2 = guestList.get(guest).get(neighbour2);
                seatingArrangementHappiness += happinessFromNeighbour1 + happinessFromNeighbour2;
            }
            if (seatingArrangementHappiness > totalChangeInHappiness) {
                totalChangeInHappiness = seatingArrangementHappiness;
                optimalSeatingArrangement = seatingArrangement;
            }
        }

        System.out.println("Optimal seating arrangement: " + optimalSeatingArrangement);
        System.out.println("Total change in happiness: " +totalChangeInHappiness);
    }

    private static void generateAllSeatingArrangements(List<String> guestList, List<String> currentArrangement, List<List<String>> seatingArrangements) {
        if (currentArrangement.size() == guestList.size()) {
            seatingArrangements.add(new ArrayList<>(currentArrangement));
            return;
        }

        for (String guest : guestList) {
            if (!currentArrangement.contains(guest)) {
                currentArrangement.add(guest);
                generateAllSeatingArrangements(guestList, currentArrangement, seatingArrangements);
                currentArrangement.remove(currentArrangement.size() - 1);
            }
        }
    }
}
