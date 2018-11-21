package com.example.fox.mrtestproject.injection;

import com.example.fox.mrtestproject.view.screeens.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void runInject(MainPresenter mainPresenter);
}