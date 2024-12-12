package shared;

import java.util.HashMap;
import java.util.Map;

import models.Evaluation;

public class SharedDatabase {
    private static final Map<String, Evaluation> evaluations = new HashMap<>();

    public static synchronized void addEvaluation(String patientName, Evaluation evaluation) {
        evaluations.put(patientName, evaluation);
    }

    public static synchronized Evaluation getEvaluation(String patientName) {
        return evaluations.get(patientName);
    }
}
