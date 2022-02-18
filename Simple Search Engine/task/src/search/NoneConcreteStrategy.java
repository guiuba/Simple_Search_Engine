package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoneConcreteStrategy implements SearchStrategy{
    @Override
    public void search(Map<Integer, String> indexContactsMap,
                       HashMap<String, HashSet<Integer>> wordIndexMap,
                       String[] queries) {

        boolean contactContainAllWords = false;
        Set<String> aux = new HashSet<>();

        for (String contact : indexContactsMap.values()) {

            for (String query : queries) {
                if (contact.toLowerCase().contains(query)) {
                    contactContainAllWords = true;
                    break;
                }
            }
            if (!contactContainAllWords) {
                aux.add(contact);
            }
            contactContainAllWords = false;
        }

        if (aux.isEmpty()) {
            System.out.println("\nNo matching people found.\n");

        } else {
            System.out.println("\n" + aux.size() + " persons found:");
            aux.forEach(System.out::println);
            System.out.println();
        }

    }
}
