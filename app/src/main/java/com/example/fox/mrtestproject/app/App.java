package com.example.fox.mrtestproject.app;

import android.app.Activity;
import android.app.Application;

import com.example.fox.mrtestproject.injection.AppComponent;
import com.example.fox.mrtestproject.injection.AppModule;
import com.example.fox.mrtestproject.injection.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    private static AppComponent appComponent;

    @Inject
    public DispatchingAndroidInjector<Activity> activityInjector;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
