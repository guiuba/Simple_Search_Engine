package search;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        //    String pathToFile = "D:\\variousTests\\testText.txt";
        String pathToFile = args[1];


        SearchManager sm = new SearchManager();
        sm.invertedIndexBuilder(pathToFile);
        sm.showMenu();

    }


}


