package com.example.roomdatabasedemo.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.students.StudentInfo;
//
//import androidx.annotation.NonNull;
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Product.class, StudentInfo.class},version = 1,exportSchema = false)
public abstract class ModelDatabase extends RoomDatabase {

    private static ModelDatabase instance;
    public abstract ModelDAO modelDAO();
    public static synchronized ModelDatabase getInstance(Context context){
        if (instance== null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    ModelDatabase.class, "model_database").//product_database
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
        private ModelDAO modelDAO;
        private PopulateDbAsyncTask(ModelDatabase modelDatabase){
            modelDAO = modelDatabase.modelDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {                                  // deprecated doInBackground
            modelDAO.insertProduct(new Product("name 1","10"));
            modelDAO.insertProduct(new Product("name 2","20"));
            modelDAO.insertProduct(new Product("name 3","30"));
            return null;
        }
    }
}
