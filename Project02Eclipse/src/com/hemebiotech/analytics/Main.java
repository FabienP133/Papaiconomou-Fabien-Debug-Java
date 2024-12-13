package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

   public static void main(String[] arguments) {
       ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
       WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile("result.out");
       AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile, writeSymptomDataToFile);

       List<String> listeSymptoms = analyticsCounter.GetSymptoms();
       Map<String, Integer> symptomesComptes = analyticsCounter.countSymptoms(listeSymptoms);

       Map<String, Integer> ordreSymptoms = analyticsCounter.sortSymptoms(symptomesComptes);

       analyticsCounter.writeSymptoms(ordreSymptoms);

   }
}
