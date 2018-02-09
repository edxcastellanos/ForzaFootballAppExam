package com.forzafootball.forzafootballexam.mvp.views;

import java.util.List;

import com.forzafootball.forzafootballexam.mvp.models.Team;

/**
 * View for the TeamsList Fragment
 * @author e.castellanos on 07/02/2018.
 */

public interface TeamsListView extends BaseView {
    void clearViews();

    void showTeamsList(List<Team> teamsList);

    void showError(Throwable throwable);
}
