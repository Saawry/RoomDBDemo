package com.example.roomdatabasedemo.students;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "students_info_table")
public class StudentInfo {
    @PrimaryKey
    @NonNull
    private String Id;
    private String studentId,studentRoll,admissionDate,DateOfBirth,ShiftId,classId,sectionId,imageName,createdTime,createdBy,status,Guardian_Phone,Relation;

    public StudentInfo() {

    }

    public StudentInfo(String id, String studentId, String studentRoll, String admissionDate, String dateOfBirth, String shiftId, String classId, String sectionId, String imageName, String createdTime, String createdBy, String status, String guardian_Phone, String relation) {
        Id = id;
        this.studentId = studentId;
        this.studentRoll = studentRoll;
        this.admissionDate = admissionDate;
        DateOfBirth = dateOfBirth;
        ShiftId = shiftId;
        this.classId = classId;
        this.sectionId = sectionId;
        this.imageName = imageName;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.status = status;
        Guardian_Phone = guardian_Phone;
        Relation = relation;
    }

    public StudentInfo(String studentId, String studentRoll, String admissionDate, String dateOfBirth, String shiftId, String classId, String sectionId, String imageName, String createdTime, String createdBy, String status, String guardian_Phone, String relation) {
        this.studentId = studentId;
        this.studentRoll = studentRoll;
        this.admissionDate = admissionDate;
        DateOfBirth = dateOfBirth;
        ShiftId = shiftId;
        this.classId = classId;
        this.sectionId = sectionId;
        this.imageName = imageName;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.status = status;
        Guardian_Phone = guardian_Phone;
        Relation = relation;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(String studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getShiftId() {
        return ShiftId;
    }

    public void setShiftId(String shiftId) {
        ShiftId = shiftId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGuardian_Phone() {
        return Guardian_Phone;
    }

    public void setGuardian_Phone(String guardian_Phone) {
        Guardian_Phone = guardian_Phone;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String relation) {
        Relation = relation;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
