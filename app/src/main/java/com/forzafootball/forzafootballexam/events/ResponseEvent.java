package com.forzafootball.forzafootballexam.events;

/**
 * ResponseEvent for the asynchronous calls to the services
 * Created by e.castellanos on 07/02/2018.
 */

public abstract class ResponseEvent<T> {
    private T payload;
    private boolean success;
    private Throwable throwable;

    public void setResult(T payload) {
        if (payload != null) {
            this.payload = payload;
            success = true;
        } else {
            this.setException(new Throwable("Null payload"));
            success = false;
        }
    }

    public void setException(Throwable throwable) {
        if (throwable != null) {
            success = false;
            this.throwable = throwable;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public T getPayload() {
        return payload;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
