package com.example.roomdatabasedemo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
//
//import androidx.annotation.NonNull;
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Product.class},version = 1,exportSchema = false)
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
            new PopulateDbAsyncTask(instance).execute();                                 //deprecated execute()
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{           //deprecated AsyncTask
        private ProductDAO productDAO;
        private PopulateDbAsyncTask(ProductDatabase productDatabase){
            productDAO=productDatabase.productDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {                                  // deprecated doInBackground
            productDAO.insertProduct(new Product("name 1","10"));
            productDAO.insertProduct(new Product("name 2","20"));
            productDAO.insertProduct(new Product("name 3","30"));
            return null;
        }
    }
}
