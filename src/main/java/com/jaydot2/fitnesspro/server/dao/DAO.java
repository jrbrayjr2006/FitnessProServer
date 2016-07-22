package com.jaydot2.fitnesspro.server.dao;

import com.jaydot2.fitnesspro.server.model.User;

/**
 * Created by jamesbray on 7/21/16.
 */
public interface DAO {

    public long getCount();

    public boolean createUser(User user);

    public User getUser(String id);
}
