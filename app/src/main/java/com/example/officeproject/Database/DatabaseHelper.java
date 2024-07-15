package com.example.officeproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.officeproject.Dao.DeliveryDao;
import com.example.officeproject.Model.DeliveryDetailsModel;

@Database(entities = {DeliveryDetailsModel.class}, exportSchema = false, version = 3)
public abstract class DatabaseHelper extends RoomDatabase {

    // Database name.
    private static final String DB_NAME = "DeliveryDetails";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context) {

        // if instance is null the create otherwise return tha instance.
        if (instance == null) {

            instance = Room.databaseBuilder(context, DatabaseHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    // Call abstract of DAO.
    public abstract DeliveryDao deliveryDao();
}
