package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface pour la lecture des symptomes
 * Récupère la liste des symptômes à partir de la source
 */
public interface ISymptomReader {
	List<String> getSymptoms();
}
