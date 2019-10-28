package by.epam.finance.dao.impl;

import by.epam.finance.bean.AuthorizationInfo;
import by.epam.finance.dao.DAOException;
import by.epam.finance.dao.UserDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUserDAO implements UserDAO {
    @Override
    public void signIn(AuthorizationInfo authorizationInfo) throws DAOException {
        String finLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("./src/by/epam/finance/UserInfo.txt"));
            finLine = br.readLine();
        } catch (IOException e) {
            throw new DAOException();
        }

        if (!finLine.equals(authorizationInfo.getLogin() + authorizationInfo.getPassword())) {
            throw new DAOException();
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new DAOException();
        }
    }
}
