package com.example.fox.mrtestproject.injection;

import android.content.Context;

import com.example.fox.mrtestproject.data.UserDataBase;
import com.example.fox.mrtestproject.executors.PostExecutionThread;
import com.example.fox.mrtestproject.repositories.UserRepository;
import com.example.fox.mrtestproject.repositories.UserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }


    @Provides
    public static UserRepository provideCoinRepository(UserRepositoryImpl userRepository) {
        return userRepository;
    }

    @Singleton
    @Provides
    public static PostExecutionThread provideUIThread(UIThread uiThread) {
        return uiThread;
    }

    @Singleton
    @Provides
    public static UserDataBase provideUserDataBase(Context context) {
        return UserDataBase.getInstance(context);
    }



}
