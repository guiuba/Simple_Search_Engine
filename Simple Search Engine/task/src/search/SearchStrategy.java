package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public interface SearchStrategy {
    void search(Map<Integer, String> indexContactsMap,
                HashMap<String, HashSet<Integer>> wordIndexMap,
                String[] queries);
}
