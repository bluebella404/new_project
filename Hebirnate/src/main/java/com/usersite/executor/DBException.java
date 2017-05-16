package com.usersite.executor;

/**
 * Created by Михаил on 2017-05-16.
 */
public class DBException extends Exception {
    public DBException(Throwable throwable) {
        super(throwable);
    }
}
