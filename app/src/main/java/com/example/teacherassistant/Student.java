package com.example.teacherassistant;

public class Student {
    private String name;
    private String department;
    private String id;
    private String year;
    private String semester;
    private String mobileNo;

    public Student(String name, String department, String id, String year, String semester, String mobileNo) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.mobileNo = mobileNo;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
