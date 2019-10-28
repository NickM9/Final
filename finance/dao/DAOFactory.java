package by.epam.finance.dao;

import by.epam.finance.dao.impl.FileBillDAO;
import by.epam.finance.dao.impl.FileUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO fileUserImpl = new FileUserDAO();
    private final BillDAO fileBillImpl = new FileBillDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return fileUserImpl;
    }

    public BillDAO getBillDAO() {
        return fileBillImpl;
    }
}
