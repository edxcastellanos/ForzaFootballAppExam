package com.forzafootball.forzafootballexam.mvp.presenters;

import com.forzafootball.forzafootballexam.mvp.views.BaseView;
import com.squareup.otto.Bus;

/**
 * Base MVP Presenter
 * Created by e.castellanos on 07/02/2018.
 */

public abstract class BasePresenter<BV extends BaseView> {
    protected BV view;
    private final Bus bus;
    private boolean isBusRegistered;

    protected BasePresenter(Bus bus) {
        this.bus = bus;
    }

    public void attachView(BV view) {
        if (!isBusRegistered) {
            bus.register(this);
            isBusRegistered = true;
        }
        this.view = view;
    }

    public void detachView() {
        if (isBusRegistered) {
            bus.unregister(this);
            isBusRegistered = false;
        }
        this.view = null;
    }

    protected boolean isViewAttached() {
        return view != null;
    }
}
