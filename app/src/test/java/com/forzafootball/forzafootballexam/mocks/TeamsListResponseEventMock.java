package com.forzafootball.forzafootballexam.mocks;

import java.util.ArrayList;
import java.util.List;

import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractor.TeamsListResponseEvent;
import com.forzafootball.forzafootballexam.mvp.models.Team;
import com.forzafootball.forzafootballexam.utils.ErrorCodeUtils;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Mock Test class for responses from Service
 * @author e.castellanos on 08/02/2018.
 */

public class TeamsListResponseEventMock {
    private static List<Team> mockTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Arsenal FC", false, "England"));
        teams.add(new Team("FC Barcelona", false, "Spain"));
        teams.add(new Team("Sweden", true, "Sweden"));
        teams.add(new Team("Inter Milan", false, "Italy"));
        return teams;
    }

    public static TeamsListResponseEvent mockSuccessResponseEmptyPayload() {
        TeamsListResponseEvent event = new TeamsListResponseEvent();
        List<Team> teams = new ArrayList<>();

        event.setResult(teams);
        return event;
    }

    public static TeamsListResponseEvent mockSuccessResponsePayloadOk() {
        TeamsListResponseEvent event = new TeamsListResponseEvent();
        List<Team> teams = mockTeams();

        event.setResult(teams);
        return event;
    }

    public static TeamsListResponseEvent mockErrorResponse(int errorCode) {
        TeamsListResponseEvent event = new TeamsListResponseEvent();
        Response<List<Team>> response = Response.error(errorCode,
                ResponseBody.create(MediaType.parse("application/json"), ""));

        event.setException(new Throwable(ErrorCodeUtils.getErrorMessageByErrorCode(response.code())));
        return event;
    }

}