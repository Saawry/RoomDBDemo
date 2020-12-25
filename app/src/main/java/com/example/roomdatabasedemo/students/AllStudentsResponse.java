package com.example.roomdatabasedemo.students;

import java.util.List;

public class AllStudentsResponse {
    private List<StudentInfo> studentInfoList;
    private String message;

    public AllStudentsResponse(List<StudentInfo> studentInfoList, String message) {
        this.studentInfoList = studentInfoList;
        this.message = message;
    }

    public List<StudentInfo> getStudentInfoList() {
        return studentInfoList;
    }

    public String getMessage() {
        return message;
    }
}
