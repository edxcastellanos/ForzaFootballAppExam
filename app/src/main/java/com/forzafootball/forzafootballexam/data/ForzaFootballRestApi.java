package com.forzafootball.forzafootballexam.data;

import java.util.List;

import com.forzafootball.forzafootballexam.mvp.models.Team;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by e.castellanos on 18/01/2018.
 * interface created to retrieve the information from services calls
 */

public interface ForzaFootballRestApi {
    @GET("/forza-assignment/android/teams.json")
    Call<List<Team>> getTeams();
}
