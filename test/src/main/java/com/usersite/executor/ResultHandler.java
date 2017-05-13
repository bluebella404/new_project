package com.usersite.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Михаил on 2017-04-30.
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
