package com.example.roomdatabasedemo;

public class StudentDetailsResponse {
    private StudentInfo data;
    private String status;

    public StudentDetailsResponse(StudentInfo data, String status) {
        this.data = data;
        this.status = status;
    }

    public StudentInfo getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
