package com.example.fox.mrtestproject.repositories;

import com.example.fox.mrtestproject.entity.User;

import java.util.List;

import io.reactivex.Flowable;

public interface UserRepository {

    //Get all users from bd
    Flowable<List<User>> getAll();
    Flowable<List<User>> getName();
    Flowable<List<User>> getTime();
    Flowable<List<User>> getPoint();

    //Add new users to bd
    void addUsers(List<User> listUsers);

    //Search User in bd
    Flowable<List<User>> search(String search);


}
