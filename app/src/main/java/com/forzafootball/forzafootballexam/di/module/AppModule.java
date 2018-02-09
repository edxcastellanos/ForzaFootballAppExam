package com.forzafootball.forzafootballexam.di.module;

import javax.inject.Singleton;

import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractor;
import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractorImpl;
import com.forzafootball.forzafootballexam.mvp.presenters.TeamsListPresenter;
import com.squareup.otto.Bus;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Application module to provide app instance
 * @author e.castellanos on 06/02/2018.
 */

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    TeamsListInteractor provideTeamsListInteractor(Bus bus, Retrofit retrofit) {
        return new TeamsListInteractorImpl(bus, retrofit);
    }

    @Provides
    @Singleton
    TeamsListPresenter provideTeamsListPresenter(final Bus bus, TeamsListInteractor teamsListInteractor) {
        return new TeamsListPresenter(bus, teamsListInteractor);
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}
