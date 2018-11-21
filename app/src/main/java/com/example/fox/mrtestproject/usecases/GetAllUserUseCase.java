package com.example.fox.mrtestproject.usecases;

import com.example.fox.mrtestproject.entity.User;
import com.example.fox.mrtestproject.executors.PostExecutionThread;
import com.example.fox.mrtestproject.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetAllUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetAllUserUseCase(UserRepository userRepository,
                             PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Flowable<List<User>> getListUser() {
        return userRepository
                .getAll()
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
