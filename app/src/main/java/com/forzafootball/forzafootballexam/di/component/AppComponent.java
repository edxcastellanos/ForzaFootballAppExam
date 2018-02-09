package com.forzafootball.forzafootballexam.di.component;

import javax.inject.Singleton;

import com.forzafootball.forzafootballexam.di.module.AppModule;
import com.forzafootball.forzafootballexam.di.module.NetModule;
import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractorImpl;
import com.forzafootball.forzafootballexam.mvp.presenters.TeamsListPresenter;
import com.forzafootball.forzafootballexam.ui.fragments.TeamsListFragment;

import dagger.Component;

/**
 * This component specifies where we will inject the app dependencies
 * Created by e.castellanos on 06/02/2018.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class })
public interface AppComponent {
    void inject(TeamsListInteractorImpl teamsListInteractorImpl);

    void inject(TeamsListPresenter teamsListPresenter);

    void inject(TeamsListFragment teamsListFragment);
}
