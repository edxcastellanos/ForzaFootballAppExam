package com.forzafootball.forzafootballexam.data;

import java.util.List;

import com.forzafootball.forzafootballexam.mvp.models.Team;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * interface created to retrieve the information from services calls
 * @author e.castellanos on 06/02/2018.
 */

public interface ForzaFootballRestApi {
    @GET("/forza-assignment/android/teams.json")
    Call<List<Team>> getTeams();
}
