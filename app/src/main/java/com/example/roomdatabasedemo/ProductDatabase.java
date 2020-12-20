package com.example.roomdatabasedemo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Product.class},version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    private static ProductDatabase instance;
    public abstract ProductDAO productDAO();
    public static synchronized ProductDatabase getInstance(Context context){
        if (instance== null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    ProductDatabase.class, "product_database").
                    fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private ProductDAO productDAO;
        private PopulateDbAsyncTask(ProductDatabase productDatabase){
            productDAO=productDatabase.productDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDAO.insertProduct(new Product("name 1","10"));
            productDAO.insertProduct(new Product("name 2","20"));
            productDAO.insertProduct(new Product("name 3","30"));
            return null;
        }
    }
}
