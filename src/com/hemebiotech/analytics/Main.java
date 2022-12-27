package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.*;
/**
 * Using interfaces like : IsymptomReader, IcountAndSort etc... as types..
 */
public class Main {

    /**
     *
     * @ return : these functions will Read a txt file, Sort and count the file in a TreeMap and write the result
     * in a file called result.out
     */
    public static void main(String[] args) throws IOException {
        AnalyticsCounter count = new AnalyticsCounter();

        ISymptomReader input = new ReadSymptomDataFromFile("Symptoms.txt");
        List<String> lireSymptoms = count.readSymptom(input);
        ICountAndSort countAndSort = new CountAndSortSymptoms(lireSymptoms);
        TreeMap<String, Integer> sortAndCount = count.sortAndCount(countAndSort);

        ISaveResult save = new SaveResult(sortAndCount);
        count.saveResult(save);

    }
}