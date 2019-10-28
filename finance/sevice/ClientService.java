package by.epam.finance.sevice;

import by.epam.finance.bean.AuthorizationInfo;

public interface ClientService {
    void signIn(AuthorizationInfo authorizationInfo) throws ServiceException;
}
