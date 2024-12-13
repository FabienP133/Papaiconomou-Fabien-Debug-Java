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

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { //là ya le constructeur donc ca c'est bon
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> GetSymptoms() { //là j'ai recup la liste des symptomes dans le fichier et le return donne la liste
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) { //là j'ai compté les occurences, j'ai créé une map que j'ap appelé symptomcount et j'ai utilisé chat pour la fin
		Map<String, Integer> symptomcount = new HashMap<>();
		for (String symptom : symptoms) {
			symptomcount.put(symptom, symptomcount.getOrDefault(symptom, 0) + 1);
		}
		return symptomcount;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { //ordre alphabétique
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms (Map<String, Integer> symptoms) { //là jai re écrit les symptomes mais triés et avec leurs occurences
		writer.writeSymptoms(symptoms);
	}

	
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

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
