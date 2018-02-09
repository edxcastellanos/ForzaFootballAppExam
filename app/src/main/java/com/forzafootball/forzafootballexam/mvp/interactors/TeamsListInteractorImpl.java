package com.forzafootball.forzafootballexam.mvp.interactors;

import java.util.List;

import javax.inject.Inject;

import com.forzafootball.forzafootballexam.data.ForzaFootballRestApi;
import com.forzafootball.forzafootballexam.mvp.models.Team;
import com.forzafootball.forzafootballexam.utils.ErrorCodeUtils;
import com.squareup.otto.Bus;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Implementation of TeamsListInteractor interface
 * Created by e.castellanos on 07/02/2018.
 */

public class TeamsListInteractorImpl implements TeamsListInteractor {
    private Retrofit retrofit;
    private Bus bus;

    @Inject
    public TeamsListInteractorImpl(Bus bus, Retrofit retrofit) {
        this.retrofit = retrofit;
        this.bus = bus;
    }

    @Override
    public TeamsListResponseEvent fetchData() {
        final TeamsListResponseEvent event = new TeamsListResponseEvent() {
        };
        Call<List<Team>> getTeams = retrofit.create(ForzaFootballRestApi.class).getTeams();

        Log.i("request", getTeams.request().url().toString());

        getTeams.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                if (response.body() != null) {
                    Log.i("body", response.body().toString());
                    event.setResult(response.body());
                    bus.post(event);
                } else {
                    String errorResponseText = ErrorCodeUtils.getErrorMessageByErrorCode(response.code());
                    Log.e("Error", errorResponseText);
                    event.setException(new Throwable(errorResponseText));
                    bus.post(event);
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                event.setException(t);
                bus.post(event);
            }
        });
        return event;
    }
}
