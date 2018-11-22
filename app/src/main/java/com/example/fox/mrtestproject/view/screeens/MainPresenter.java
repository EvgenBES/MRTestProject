package com.example.fox.mrtestproject.view.screeens;

import android.util.Log;

import com.example.fox.mrtestproject.app.App;
import com.example.fox.mrtestproject.entity.User;
import com.example.fox.mrtestproject.usecases.AddUserUseCase;
import com.example.fox.mrtestproject.usecases.GetAllUserUseCase;
import com.example.fox.mrtestproject.usecases.GetSortNameUserUseCase;
import com.example.fox.mrtestproject.usecases.GetSortPointUserUseCase;
import com.example.fox.mrtestproject.usecases.GetSortTimeUserUseCase;
import com.example.fox.mrtestproject.usecases.SearchUserUseCase;
import com.example.fox.mrtestproject.view.base.BaseViewModel;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;

public class MainPresenter extends BaseViewModel {

    private MainView mainView;

    @Inject
    public GetAllUserUseCase getAllUserUseCase;
    @Inject
    public GetSortNameUserUseCase sortNameUserUseCase;
    @Inject
    public GetSortPointUserUseCase sortPointUserUseCase;
    @Inject
    public GetSortTimeUserUseCase sortTimeUserUseCase;
    @Inject
    public SearchUserUseCase searchUserUseCase;
    @Inject
    public AddUserUseCase addUserUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }


    MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    void onResume() {
        if (mainView != null) {
            addUserUseCase
                    .addUser(addUsers());

            loadUserDB();
        }
    }


    void onDestroy() {
        mainView = null;
    }


    private List<User> addUsers() {
        List<User> listUsers = new ArrayList<>();

        listUsers.add(new User(1, "Ivanov Stefan Eduardov", "7Б", 196, 78));
        listUsers.add(new User(2, "Ivanova Anna Albertovna", "5Г", 225, 18));
        listUsers.add(new User(3, "Puchkov Sergey Petrovich", "3З", 146, 73));
        listUsers.add(new User(4, "Balan Dmitriy Bedrosovich", "8А", 325, 15));
        listUsers.add(new User(5, "Grigor Stepan Iosevech", "6В", 96, 44));

        return listUsers;
    }


    public void loadUserDB() {
        getAllUserUseCase
                .getListUser()
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        try {
                            mainView.setItems(users);
                        } catch (Exception ignored) {

                        }

                    }
                })
                .isDisposed();

    }

    public void sortNameUser() {
        sortNameUserUseCase
                .getSortNameUser()
                .subscribe(users -> {
                    try {
                        mainView.setItems(users);
                    } catch (Exception ignored) {
                    }
                })
                .isDisposed();
    }

    public void sortTimeUser() {
        sortTimeUserUseCase
                .getSortTimeUser()
                .subscribe(users -> {
                    try {
                        mainView.setItems(users);
                    } catch (Exception ignored) {
                    }
                })
                .isDisposed();
    }

    public void sortPointUser() {
        sortPointUserUseCase
                .getSortPointUser()
                .subscribe(users -> {
                    try {
                        mainView.setItems(users);
                    } catch (Exception ignored) {

                    }
                })
                .isDisposed();
    }

    public void searchUser(String search) {
        searchUserUseCase
                .searchUser(search)
                .subscribe(users -> {
                    try {
                        mainView.setItems(users);
                    } catch (Exception ignored) {
                    }
                })
                .isDisposed();
    }
}