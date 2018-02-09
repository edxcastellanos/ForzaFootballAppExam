package com.forzafootball.forzafootballexam.mvp.models;

/**
 * Class used to retrieve Team information from service using GSON
 * @author e.castellanos on 06/02/2018.
 */

public class Team {
    private String name;
    private boolean national;
    private String country_name;

    public Team(String name, boolean national, String country_name) {
        this.name = name;
        this.national = national;
        this.country_name = country_name;
    }

    public String getName() {
        return name;
    }

    public boolean isNational() {
        return national;
    }

    public String getCountry_name() {
        return country_name;
    }
}
