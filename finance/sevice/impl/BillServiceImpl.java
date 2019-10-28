package by.epam.finance.sevice.impl;

import by.epam.finance.bean.Bill;
import by.epam.finance.dao.BillDAO;
import by.epam.finance.dao.DAOException;
import by.epam.finance.dao.DAOFactory;
import by.epam.finance.sevice.BillService;
import by.epam.finance.sevice.ServiceException;

import java.io.IOException;
import java.util.List;

public class BillServiceImpl implements BillService {

    @Override
    public void addBill(Bill bill) throws ServiceException {
        if (bill.getSum() != 0) {
            DAOFactory daoFactoryObject = DAOFactory.getInstance();
            BillDAO billDAO = daoFactoryObject.getBillDAO();
            try {
                billDAO.addBill(bill);
            } catch (DAOException | IOException e) {
                throw new ServiceException(e);
            }
        }

    }

    @Override
    public int calculateExpenses() throws ServiceException {
        int expenses = 0;

        DAOFactory daoFactoryObject = DAOFactory.getInstance();
        BillDAO billDAO = daoFactoryObject.getBillDAO();

        try {
            List<Integer> allExpenses = billDAO.selectExpenses();

            for (Integer i : allExpenses
            ) {
                expenses += i;
            }

            return expenses;
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }


    @Override
    public void replaceBill(Bill a, Bill b) throws ServiceException {
        if (a.getSum() != b.getSum()) {
            DAOFactory daoFactoryObject = DAOFactory.getInstance();
            BillDAO billDAO = daoFactoryObject.getBillDAO();
            try {
                billDAO.replaceBill(a, b);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
    }

    @Override
    public void deleteBill(Bill bill) throws ServiceException {
        DAOFactory daoFactoryObject = DAOFactory.getInstance();
        BillDAO billDAO = daoFactoryObject.getBillDAO();
        try {
            billDAO.deleteBill(bill);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
