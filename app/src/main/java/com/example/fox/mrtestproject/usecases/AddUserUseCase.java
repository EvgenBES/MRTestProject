package com.example.fox.mrtestproject.usecases;

import com.example.fox.mrtestproject.entity.User;
import com.example.fox.mrtestproject.executors.PostExecutionThread;
import com.example.fox.mrtestproject.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

public class AddUserUseCase extends BaseUseCase {
    private UserRepository userRepository;

    @Inject
    public AddUserUseCase(UserRepository userRepository,
                          PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public void addUser(List<User> listUsers) {
        userRepository
               .addUsers(listUsers);
    }
}
