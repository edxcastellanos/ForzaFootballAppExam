package com.forzafootball.forzafootballexam.mvp.interactors;

import java.util.List;

import com.forzafootball.forzafootballexam.events.ResponseEvent;
import com.forzafootball.forzafootballexam.mvp.models.Team;

/**
 * Interactor interface to retrieve information from service
 * Created by e.castellanos on 07/02/2018.
 */

public interface TeamsListInteractor {
    TeamsListResponseEvent fetchData();

    class TeamsListResponseEvent extends ResponseEvent<List<Team>> {
    }
}
