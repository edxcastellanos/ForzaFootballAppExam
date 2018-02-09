package com.forzafootball.forzafootballexam.mvp.presenters;

import javax.inject.Inject;

import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractor;
import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractor.TeamsListResponseEvent;
import com.forzafootball.forzafootballexam.mvp.views.TeamsListView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Presenter for the TeamsList Fragment
 * @author e.castellanos on 07/02/2018.
 */

public class TeamsListPresenter extends BasePresenter<TeamsListView> {
    private TeamsListInteractor teamsListInteractor;

    @Inject
    public TeamsListPresenter(Bus bus, TeamsListInteractor teamsListInteractor) {
        super(bus);
        this.teamsListInteractor = teamsListInteractor;
    }

    public void fetchData() {
        teamsListInteractor.fetchData();
    }

    @Subscribe
    public void onTicketListingEvent(TeamsListResponseEvent event) {
        if (event.getPayload() != null && event.isSuccess()) {
            view.showTeamsList(event.getPayload());
        } else {
            view.showError(event.getThrowable());
        }
    }

}
