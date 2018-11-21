package com.example.fox.mrtestproject.usecases;

import com.example.fox.mrtestproject.entity.User;
import com.example.fox.mrtestproject.executors.PostExecutionThread;
import com.example.fox.mrtestproject.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetSortNameUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetSortNameUserUseCase(UserRepository userRepository,
                                  PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Flowable<List<User>> getSortNameUser() {
        return userRepository
                .getName()
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
