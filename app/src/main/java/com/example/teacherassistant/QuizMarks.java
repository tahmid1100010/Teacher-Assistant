package com.example.teacherassistant;

public class QuizMarks {
    private String id;
    private String obMarks;
    private String totMarks;

    public QuizMarks(String id, String obMarks, String totMarks) {
        this.id = id;
        this.obMarks = obMarks;
        this.totMarks = totMarks;
    }

    public QuizMarks(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObMarks() {
        return obMarks;
    }

    public void setObMarks(String obMarks) {
        this.obMarks = obMarks;
    }

    public String getTotMarks() {
        return totMarks;
    }

    public void setTotMarks(String totMarks) {
        this.totMarks = totMarks;
    }
}
