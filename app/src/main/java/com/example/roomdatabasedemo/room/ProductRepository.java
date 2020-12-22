package com.example.roomdatabasedemo.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

//import androidx.lifecycle.LiveData;


import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.room.ProductDAO;
import com.example.roomdatabasedemo.room.ProductDatabase;

import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;
    private LiveData<List<Product>> allProducts;

    public ProductRepository(Application application) {

        ProductDatabase productDatabase = ProductDatabase.getInstance(application);
        productDAO = productDatabase.productDAO();
        allProducts = productDAO.getAllProducts();
    }

    public void insert(Product product) {
        new InsertProductAsyncTask(productDAO).execute(product);
    }

    public void update(Product product) {
        new UpdateProductAsyncTask(productDAO).execute(product);
    }

    public void delete(Product product) {
        new DeleteProductAsyncTask(productDAO).execute(product);
    }

    public void deleteAllProducts() {
        new DeleteAllProductsAsyncTask(productDAO).execute();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }


    private static class InsertProductAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDAO productDAO;

        public InsertProductAsyncTask(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.insertProduct(products[0]);
            return null;
        }
    }
    private static class UpdateProductAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDAO productDAO;

        public UpdateProductAsyncTask(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.updateProduct(products[0]);
            return null;
        }
    }
    private static class DeleteProductAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDAO productDAO;

        public DeleteProductAsyncTask(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.deleteProduct(products[0]);
            return null;
        }
    }
    private static class DeleteAllProductsAsyncTask extends AsyncTask<Void, Void, Void> {

        private ProductDAO productDAO;

        public DeleteAllProductsAsyncTask(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDAO.deleteAllProducts();
            return null;
        }
    }
//    private static class GetAllProductsAsyncTask extends AsyncTask<Product, Void, Void> {
//
//        private ProductDAO productDAO;
//
//        public GetAllProductsAsyncTask(ProductDAO productDAO) {
//            this.productDAO = productDAO;
//        }
//
//        @Override
//        protected Void doInBackground(Product... products) {
//            productDAO.getAllProducts();
//            return null;
//        }
//    }

}
