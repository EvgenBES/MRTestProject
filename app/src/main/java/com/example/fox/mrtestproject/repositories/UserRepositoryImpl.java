package com.example.fox.mrtestproject.repositories;

import com.example.fox.mrtestproject.data.UserDataBase;
import com.example.fox.mrtestproject.data.UserResponce;
import com.example.fox.mrtestproject.entity.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UserRepositoryImpl implements UserRepository {

    private UserDataBase dataBase;

    @Inject
    public UserRepositoryImpl(UserDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Flowable<List<User>> getAll() {
        return dataBase
                .getUserDAO()
                .getAll()
                .map(new Function<List<UserResponce>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponce> userResponces) throws Exception {
                        final List<User> list = new ArrayList<>();
                        for (UserResponce users : userResponces) {
                            list.add(new User(
                                    users.getId(),
                                    users.getName(),
                                    users.getClassRoom(),
                                    users.getTime(),
                                    users.getPoints()
                            ));
                        }
                        return list;
                    }
                });
    }

    @Override
    public Flowable<List<User>> getName() {
        return dataBase
                .getUserDAO()
                .getSortName()
                .map(new Function<List<UserResponce>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponce> userResponces) throws Exception {
                        final List<User> list = new ArrayList<>();
                        for (UserResponce users : userResponces) {
                            list.add(new User(
                                    users.getId(),
                                    users.getName(),
                                    users.getClassRoom(),
                                    users.getTime(),
                                    users.getPoints()
                            ));
                        }
                        return list;
                    }
                });
    }

    @Override
    public Flowable<List<User>> getTime() {
        return dataBase
                .getUserDAO()
                .getSortTime()
                .map(new Function<List<UserResponce>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponce> userResponces) throws Exception {
                        final List<User> list = new ArrayList<>();
                        for (UserResponce users : userResponces) {
                            list.add(new User(
                                    users.getId(),
                                    users.getName(),
                                    users.getClassRoom(),
                                    users.getTime(),
                                    users.getPoints()
                            ));
                        }
                        return list;
                    }
                });
    }

    @Override
    public Flowable<List<User>> getPoint() {
        return dataBase
                .getUserDAO()
                .getSortPoint()
                .map(new Function<List<UserResponce>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponce> userResponces) throws Exception {
                        final List<User> list = new ArrayList<>();
                        for (UserResponce users : userResponces) {
                            list.add(new User(
                                    users.getId(),
                                    users.getName(),
                                    users.getClassRoom(),
                                    users.getTime(),
                                    users.getPoints()
                            ));
                        }
                        return list;
                    }
                });
    }

    @Override
    public void addUsers(List<User> listUsers) {
        Observable.just(dataBase)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserDataBase>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserDataBase userDataBase) {
                        dataBase.getUserDAO().deleteAll();
                        for (User listUser : listUsers) {
                            dataBase.getUserDAO().insert(new UserResponce(
                                    listUser.getName(),
                                    listUser.getClassRoom(),
                                    listUser.getTime(),
                                    listUser.getPoints()
                            ));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public Flowable<List<User>> search(String search) {
        return dataBase
                .getUserDAO()
                .searchName(search)
                .map(new Function<List<UserResponce>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponce> userResponces) throws Exception {
                        final List<User> list = new ArrayList<>();
                        for (UserResponce users : userResponces) {
                            list.add(new User(
                                    users.getId(),
                                    users.getName(),
                                    users.getClassRoom(),
                                    users.getTime(),
                                    users.getPoints()
                            ));
                        }
                        return list;
                    }
                });
    }
}
