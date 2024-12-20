package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;


	/**
	 * Constructeur de la classe AnalyticsCounter
	 */
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
	 * Trie les symptomes par ordre alphabétique
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}


	/**
	 * Ecrit les symptômes triés et leurs occurrences dans un fichier via le writer
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}