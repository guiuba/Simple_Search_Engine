package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnyConcreteStrategy implements SearchStrategy {
    @Override
    public void search(Map<Integer, String> indexContactsMap,
                       HashMap<String, HashSet<Integer>> wordIndexMap,
                       String[] queries) {

        Set<Integer> aux = new HashSet<>();

        for (String query : queries) {
            for (String word : wordIndexMap.keySet()) {
                if (query.length() > 1) {
                    if (word.contains(query)) {
                        aux.addAll(wordIndexMap.get(word));
                    }
                }
            }
        }

        if (aux.isEmpty()) {
            System.out.println("\nNo matching people found.\n");

        } else {
            System.out.println("\n" + aux.size() + " persons found:");
            aux.forEach(index -> System.out.println(indexContactsMap.get(index)));
            System.out.println();
        }
    }
}
