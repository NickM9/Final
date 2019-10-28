package by.epam.finance.sevice.impl;

import by.epam.finance.bean.AuthorizationInfo;
import by.epam.finance.dao.DAOException;
import by.epam.finance.dao.DAOFactory;
import by.epam.finance.dao.UserDAO;
import by.epam.finance.sevice.ClientService;
import by.epam.finance.sevice.ServiceException;

public class ClientServiceImpl implements ClientService {

    @Override
    public void signIn(AuthorizationInfo authorizationInfo) throws ServiceException {

        String login = authorizationInfo.getLogin();
        String password = authorizationInfo.getPassword();
        if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
            throw new ServiceException("Incorrect login and/or password.");
        }

        DAOFactory daoFactoryObject = DAOFactory.getInstance();
        UserDAO userDAO = daoFactoryObject.getUserDAO();
        try {
            userDAO.signIn(authorizationInfo);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
