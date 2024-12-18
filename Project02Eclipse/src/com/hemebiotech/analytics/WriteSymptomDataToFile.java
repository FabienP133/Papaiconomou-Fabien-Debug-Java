package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }


    /**
     * Écrit les symptômes et leur occurrence dans un fichier texte
     * Chaque symptôme est suivi de son nombre d'occurrences, avec "symptôme : valeur"
     * Si le chemin du fichier ou la map de symptômes est null, un message d'erreur est affiché et l'écriture est interrompue
     * En cas d'erreur d'écriture dans le fichier, une exception est gérée
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath == null || symptoms == null) {
            System.err.println("le chemin vers le fichier ou les symptomes ne sont pas bons");
            return;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                writer.write(symptom.getKey() + " : " + symptom.getValue());
                writer.newLine();
            }
            writer.close();

            System.out.println("Les symptomes sont dans le fichier " + filepath);
        } catch (IOException e) {
            System.err.println("Impossible d'écrire dans le fichier " + e.getMessage());
        }
    }
}
