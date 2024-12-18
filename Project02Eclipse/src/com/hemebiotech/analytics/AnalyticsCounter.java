package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private ISymptomReader reader;
	private ISymptomWriter writer;


/**
 * Constructeur de la classe AnalyticsCounter
 * */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Récupère la liste des symptomes
     */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}


	/**
	 * Compte les occurrences de chaque symptomes dans la liste
     */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomcount = new HashMap<>();
		for (String symptom : symptoms) {
			symptomcount.put(symptom, symptomcount.getOrDefault(symptom, 0) + 1);
		}
		return symptomcount;
	}


	/**
	 *Trie les symptomes par ordre alphabétique
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}


	/**
	 *Ecrit les symptômes triés et leurs occurrences dans un fichier via le writer
	 */
	public void writeSymptoms (Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	/**
	 * Cette méthode lit le fichier des symptômes à partir de "symptoms.txt", compte les occurences puis écrit les résultats dans "result.out"
	 */
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}

		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
