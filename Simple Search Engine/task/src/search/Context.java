package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Context {
    private SearchStrategy searchStrategy;

    public void setMethod(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void search(Map<Integer, String> indexContactsMap,
                       HashMap<String, HashSet<Integer>> wordIndexMap,
                       String[] queries) {
        this.searchStrategy.search(indexContactsMap, wordIndexMap, queries);
    }
}
