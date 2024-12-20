package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Écrit les symptômes et leurs occurrences
     * @param symptoms
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
