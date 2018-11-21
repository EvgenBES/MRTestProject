package com.example.fox.mrtestproject.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserResponce.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "user.db";


    public static UserDataBase getInstance(Context context) {
        UserDataBase dataBase = Room.databaseBuilder(context, UserDataBase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        return dataBase;
    }

    public abstract UserDAO getUserDAO();
}
