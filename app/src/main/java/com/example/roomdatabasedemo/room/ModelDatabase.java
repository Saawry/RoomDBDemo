package com.example.roomdatabasedemo.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;

import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.actor.Actor;

@Database(entities = {Product.class, Actor.class},version = 1,exportSchema = false)
public abstract class ModelDatabase extends RoomDatabase {

    private static ModelDatabase instance;
    public abstract ModelDAO modelDAO();
    public static synchronized ModelDatabase getInstance(Context context){
        if (instance== null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    ModelDatabase.class, "model_database")//product_database
                    //.fallbackToDestructiveMigration()
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
        protected Void doInBackground(Void... voids) {
            modelDAO.deleteAllActors();// deprecated doInBackground
            modelDAO.insertProduct(new Product("name 1","10"));
            modelDAO.insertProduct(new Product("name 2","20"));
            modelDAO.insertProduct(new Product("name 3","30"));
            return null;
        }
    }
}
