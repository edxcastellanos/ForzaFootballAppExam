package com.forzafootball.forzafootballexam.ui.adapters;

import java.util.ArrayList;
import java.util.List;

import com.forzafootball.forzafootballexam.R;
import com.forzafootball.forzafootballexam.mvp.models.Team;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Adapter for the Teams List recyclerView
 * Created by e.castellanos on 07/02/2018.
 */

public class TeamsListAdapter extends RecyclerView.Adapter<TeamsListAdapter.TeamListViewHolder> {
    private List<Team> teamsList = new ArrayList<>();

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public void clearItemsAndNotify() {
        if (!this.teamsList.isEmpty()) {
            this.teamsList.clear();
            notifyDataSetChanged();
        }
    }

    public void addTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
        notifyDataSetChanged();
    }

    @Override
    public TeamListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_row, parent, false);
        return new TeamListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeamListViewHolder holder, int position) {
        Team team = teamsList.get(position);
        holder.name.setText(team.getName());
        if (team.isNational()) {
            holder.national.setVisibility(View.VISIBLE);
        }
        holder.country_name.setText(team.getCountry_name());
    }

    class TeamListViewHolder extends RecyclerView.ViewHolder {
        TextView name, national, country_name;

        TeamListViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txtTeamName);
            national = view.findViewById(R.id.txtIsNational);
            country_name = view.findViewById(R.id.txtCountryName);
        }
    }
}
