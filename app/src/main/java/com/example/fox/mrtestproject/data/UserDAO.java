package com.example.fox.mrtestproject.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDAO {
    String TABLE_NAME = "users";

    @Insert
    void insert(UserResponce userResponce);

    @Query("DELETE FROM " + TABLE_NAME)
    void deleteAll();

    @Query("SELECT * FROM " + TABLE_NAME)
    Flowable<List<UserResponce>> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " ORDER BY name")
    Flowable<List<UserResponce>> getSortName();

    @Query("SELECT * FROM " + TABLE_NAME + " ORDER BY time")
    Flowable<List<UserResponce>> getSortTime();

    @Query("SELECT * FROM " + TABLE_NAME + " ORDER BY points")
    Flowable<List<UserResponce>> getSortPoint();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE name LIKE '%' || :search || '%'")
    Flowable<List<UserResponce>> searchName(String search);

}
