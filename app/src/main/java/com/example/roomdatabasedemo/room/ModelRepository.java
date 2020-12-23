package com.example.roomdatabasedemo.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

//import androidx.lifecycle.LiveData;


import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.students.StudentInfo;

import java.util.List;

public class ModelRepository {
    private ModelDAO modelDAO;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<StudentInfo>> allStudents;

    public ModelRepository(Application application) {

        ModelDatabase modelDatabase = ModelDatabase.getInstance(application);
        modelDAO = modelDatabase.modelDAO();
        allProducts = modelDAO.getAllProducts();
        allStudents = modelDAO.getAllStudents();
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
    public LiveData<List<StudentInfo>> getAllStudents() {
        return allStudents;
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

}
