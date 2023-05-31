package src.repositories;

import java.util.Map;

public interface DataRepository {

    /**
     * Returns map of guestlist with happiness of attendees
     * @param datafile .
     */
    Map<String, Map<String, Integer>> getAll(String datafile);
}
