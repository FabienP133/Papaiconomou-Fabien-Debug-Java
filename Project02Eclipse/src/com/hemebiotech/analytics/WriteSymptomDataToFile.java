package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath == null || symptoms == null) {
            System.out.println("le chemin vers le fichier ou les symptomes ne sont pas bons");

            } //je ne sais pas si je dois fermer ici ou pas

            try {
                BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
                String line = writer.writeLine();
            }




    }

}
