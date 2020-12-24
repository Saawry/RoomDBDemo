package com.example.roomdatabasedemo.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

//import androidx.lifecycle.LiveData;


import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.actor.Actor;
import com.example.roomdatabasedemo.students.StudentInfo;

import java.util.List;

public class ModelRepository {
    private ModelDAO modelDAO;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<StudentInfo>> allStudents;


    private LiveData<List<Actor>> allActors;

    public ModelRepository(Application application) {

        ModelDatabase modelDatabase = ModelDatabase.getInstance(application);
        modelDAO = modelDatabase.modelDAO();
        allProducts = modelDAO.getAllProducts();
        allStudents = modelDAO.getAllStudents();

        allActors = modelDAO.getAllActors();
    }

    public void insert(Product product) {
        new InsertProductAsyncTask(modelDAO).execute(product);
    }

    public void update(Product product) {
        new UpdateProductAsyncTask(modelDAO).execute(product);
    }

    public void delete(Product product) {
        new DeleteProductAsyncTask(modelDAO).execute(product);
    }

    public void deleteAllProducts() {
        new DeleteAllProductsAsyncTask(modelDAO).execute();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    private static class InsertProductAsyncTask extends AsyncTask<Product, Void, Void> {

        private ModelDAO modelDAO;

        public InsertProductAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            modelDAO.insertProduct(products[0]);
            return null;
        }
    }
    private static class UpdateProductAsyncTask extends AsyncTask<Product, Void, Void> {

        private ModelDAO modelDAO;

        public UpdateProductAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            modelDAO.updateProduct(products[0]);
            return null;
        }
    }
    private static class DeleteProductAsyncTask extends AsyncTask<Product, Void, Void> {

        private ModelDAO modelDAO;

        public DeleteProductAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            modelDAO.deleteProduct(products[0]);
            return null;
        }
    }
    private static class DeleteAllProductsAsyncTask extends AsyncTask<Void, Void, Void> {

        private ModelDAO modelDAO;

        public DeleteAllProductsAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            modelDAO.deleteAllProducts();
            return null;
        }
    }
//    private static class GetAllProductsAsyncTask extends AsyncTask<Product, Void, Void> {
//
//        private ModelDAO modelDAO;
//
//        public GetAllProductsAsyncTask(ModelDAO modelDAO) {
//            this.modelDAO = modelDAO;
//        }
//
//        @Override
//        protected Void doInBackground(Product... products) {
//            modelDAO.getAllProducts();
//            return null;
//        }
//    }


    public void InsertStudent(StudentInfo studentInfo){new InsertStudentAsyncTask(modelDAO).execute(studentInfo);}
    public void UpdateStudent(StudentInfo studentInfo){new UpdateStudentAsyncTask(modelDAO).execute(studentInfo);}
    public void DeleteStudent(StudentInfo studentInfo){new DeleteStudentAsyncTask(modelDAO).execute(studentInfo);}
    public void DeleteAllStudent(){new DeleteAllStudentAsyncTask(modelDAO).execute();}
    public void InsertAllStudent(List<StudentInfo> studentInfoList){new InsertAllStudentAsyncTask(modelDAO).execute(studentInfoList);}
    public LiveData<List<StudentInfo>> getAllStudents() {
        return allStudents;
    }

    private static class InsertStudentAsyncTask extends AsyncTask<StudentInfo,Void,Void>{

        private ModelDAO modelDAO;

        public InsertStudentAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(StudentInfo... studentInfos) {
            modelDAO.insertStudent(studentInfos[0]);
            return null;
        }
    }
    private static class UpdateStudentAsyncTask extends AsyncTask<StudentInfo,Void,Void>{

        private ModelDAO modelDAO;

        public UpdateStudentAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(StudentInfo... studentInfos) {
            modelDAO.updateStudent(studentInfos[0]);
            return null;
        }
    }
    private static class DeleteStudentAsyncTask extends AsyncTask<StudentInfo,Void,Void>{

        private ModelDAO modelDAO;

        public DeleteStudentAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(StudentInfo... studentInfos) {
            modelDAO.deleteStudent(studentInfos[0]);
            return null;
        }
    }
    private static class DeleteAllStudentAsyncTask extends AsyncTask<Void,Void,Void>{

        private ModelDAO modelDAO;

        public DeleteAllStudentAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            modelDAO.deleteAllStudents();
            return null;
        }
    }
    private static class InsertAllStudentAsyncTask extends AsyncTask<List<StudentInfo>,Void,Void>{
        private ModelDAO modelDAO;

        public InsertAllStudentAsyncTask(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(List<StudentInfo>... lists) {
            modelDAO.insertAllStudent(lists[0]);
            return null;
        }
    }




    //--------------

    public LiveData<List<Actor>> getAllActors() {
        return allActors;
    }
    public void InsertAllActors(List<Actor> actors){new InsertAllActors(modelDAO).execute(actors);}
    private static class InsertAllActors extends AsyncTask<List<Actor>,Void,Void>{

        private ModelDAO modelDAO;

        public InsertAllActors(ModelDAO modelDAO) {
            this.modelDAO = modelDAO;
        }

        @Override
        protected Void doInBackground(List<Actor>... lists) {
            modelDAO.insertActors(lists[0]);
            return null;
        }
    }
}
