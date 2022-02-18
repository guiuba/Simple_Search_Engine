package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchManager {

    private Scanner scan = new Scanner(System.in);
    Map<Integer, String> indexContactsMap;
    HashMap<String, HashSet<Integer>> wordIndexMap;
    Context context;


    SearchManager() {
        this.indexContactsMap = new HashMap<>();
        this.wordIndexMap = new HashMap<>();
        this.context = new Context();
    }


    void invertedIndexBuilder(String pathToFile) {

        int index = 0;
        File file = new File(pathToFile);

        try (Scanner scan = new Scanner(file)) {

            while (scan.hasNext()) {
                String contact = scan.nextLine();
                String[] contactParts = contact.split("\\s+");
                indexContactsMap.put(index, contact);

                for (int i = 0; i < contactParts.length; i++) {
                    String word = contactParts[i].toLowerCase();

                    wordIndexMap.putIfAbsent(word, new HashSet<Integer>());
                    wordIndexMap.get(word).add(index);
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }


    void showMenu() {
        while (true) {
            System.out.println("=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");

            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    selectStrategy();
                    break;
                case 2:
                    System.out.println("\n=== List of people ===");
                    indexContactsMap.values().forEach(System.out::println);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("\nBye!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect option! Try again.");
                    System.out.println();
            }
        }
    }

    void selectStrategy() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        switch (scan.nextLine().toLowerCase()) {
            case "all":
                context.setMethod(new AllConcreteStrategy());
                context.search(indexContactsMap, wordIndexMap, printQueryCatcher());
                break;
            case "any":
                context.setMethod(new AnyConcreteStrategy());
                context.search(indexContactsMap, wordIndexMap, printQueryCatcher());
                break;
            case "none":
                context.setMethod(new NoneConcreteStrategy());
                context.search(indexContactsMap, wordIndexMap, printQueryCatcher());
                break;
            default:

                break;
        }
    }

    String[] printQueryCatcher() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        return scan.nextLine().toLowerCase().split("\\s+");
    }
}
