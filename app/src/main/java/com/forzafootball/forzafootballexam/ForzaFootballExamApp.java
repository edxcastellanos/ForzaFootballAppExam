package com.forzafootball.forzafootballexam;

import com.forzafootball.forzafootballexam.di.component.AppComponent;
import com.forzafootball.forzafootballexam.di.component.DaggerAppComponent;
import com.forzafootball.forzafootballexam.di.module.AppModule;
import com.forzafootball.forzafootballexam.di.module.NetModule;

import android.app.Application;

/**
 * Application class to create dagger AppComponent
 * Created by e.castellanos on 06/02/2018.
 */

public class ForzaFootballExamApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .netModule(new NetModule("https://s3-eu-west-1.amazonaws.com/")).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
