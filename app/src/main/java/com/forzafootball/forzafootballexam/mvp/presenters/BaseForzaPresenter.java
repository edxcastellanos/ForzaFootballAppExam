package com.forzafootball.forzafootballexam.mvp.presenters;

import com.forzafootball.forzafootballexam.mvp.views.BaseView;
import com.squareup.otto.Bus;

/**
 * Base Presenter which contains Otto bus
 * Created by e.castellanos on 07/02/2018.
 */

public class BaseForzaPresenter<BV extends BaseView> extends BasePresenter<BV> {
    protected BaseForzaPresenter(Bus bus) {
        super(bus);
    }
}
