package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

public interface UserDAO extends BaseDAO<User> {

    User getByLogin(String login) throws DBException;
}
