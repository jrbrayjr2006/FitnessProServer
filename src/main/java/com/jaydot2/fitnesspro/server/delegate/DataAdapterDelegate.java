package com.jaydot2.fitnesspro.server.delegate;

import com.jaydot2.fitnesspro.server.dao.DAO;
import com.jaydot2.fitnesspro.server.model.User;
import org.springframework.stereotype.Component;

/**
 *
 * <p>
 *     This delegate is used for any preprocessing of data that will be inputs to the data persistence layer
 * </p>
 * Created by jamesbray on 7/3/16.
 */
@Component("DataDelegate")
public class DataAdapterDelegate implements DAO {

    @Override
    public void setDatabaseConnection(String server, int port) {

    }

    @Override
    public long getCount() {
        //TODO
        return 0;
    }

    @Override
    public boolean createUser(User user) {
        //TODO
        return false;
    }

    @Override
    public User getUser(String id) {
        //TODO
        return null;
    }
}
