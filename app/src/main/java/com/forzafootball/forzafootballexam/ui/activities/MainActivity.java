package com.forzafootball.forzafootballexam.ui.activities;

import com.forzafootball.forzafootballexam.R;
import com.forzafootball.forzafootballexam.ui.fragments.TeamsListFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TEAM_LIST_FRAGMENT_TAG = "TeamList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();

        if (savedInstanceState == null) {
            Fragment teamsListFragment = TeamsListFragment.newInstance();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.fragment_container, teamsListFragment, TEAM_LIST_FRAGMENT_TAG).commit();
        }
    }
}
