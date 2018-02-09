package com.forzafootball.forzafootballexam.ui.fragments;

import javax.inject.Inject;

import com.forzafootball.forzafootballexam.ForzaFootballExamApp;
import com.forzafootball.forzafootballexam.R;
import com.forzafootball.forzafootballexam.mvp.models.Team;
import com.forzafootball.forzafootballexam.mvp.presenters.TeamsListPresenter;
import com.forzafootball.forzafootballexam.mvp.views.TeamsListView;
import com.forzafootball.forzafootballexam.ui.adapters.TeamsListAdapter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Fragment for the List of teams displayed in a RecyclerView
 * Created by e.castellanos on 07/02/2018.
 */

public class TeamsListFragment extends Fragment implements TeamsListView {
    private TeamsListAdapter teamsListAdapter;

    @Inject
    TeamsListPresenter teamsListPresenter;

    public static Fragment newInstance() {
        return new TeamsListFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        clearViews();
        teamsListPresenter.attachView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((ForzaFootballExamApp) getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teams_list, container, false);
        initRecyclerView(rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        teamsListPresenter.attachView(this);
        teamsListPresenter.fetchData();
    }

    @Override
    public void onDetach() {
        teamsListPresenter.detachView();
        super.onDetach();
    }

    private void initRecyclerView(View rootView) {
        teamsListAdapter = new TeamsListAdapter();
        RecyclerView recyclerView = rootView.findViewById(R.id.teams_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(teamsListAdapter);
    }

    @Override
    public void clearViews() {
        teamsListAdapter.clearItemsAndNotify();
    }

    @Override
    public void showTeamsList(List<Team> teamsList) {
        teamsListAdapter.addTeamsList(teamsList);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
