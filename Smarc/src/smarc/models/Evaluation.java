package models;

import java.io.Serializable;

public class Evaluation implements Serializable {
    private String patientName;
    private String results;

    public Evaluation(String patientName, String results) {
        this.patientName = patientName;
        this.results = results;
    }
}
