package by.epam.finance.dao;

import by.epam.finance.bean.AuthorizationInfo;

public interface UserDAO {
    void signIn(AuthorizationInfo authorizationInfo) throws DAOException;
}
