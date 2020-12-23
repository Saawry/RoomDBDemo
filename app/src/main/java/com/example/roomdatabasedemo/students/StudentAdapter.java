package com.example.roomdatabasedemo.students;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roomdatabasedemo.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<StudentInfo> students = new ArrayList<>();

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_details_card, viewGroup, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int position) {

        StudentInfo currentStudent = students.get(position);
        studentViewHolder.idTv.setText(currentStudent.getStudentId());

        studentViewHolder.itemView.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void setStudents(List<StudentInfo> student) {
        this.students = student;
        notifyDataSetChanged();
    }
    public StudentInfo getStudentAt(int position) {
        return students.get(position);
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        private TextView idTv;
        private ImageView StudentImg;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            idTv=itemView.findViewById(R.id.student_card_id);
            StudentImg=itemView.findViewById(R.id.student_card_img);

        }
    }
}
