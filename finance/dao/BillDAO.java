package by.epam.finance.dao;

import by.epam.finance.bean.Bill;

import java.io.IOException;
import java.util.List;

public interface BillDAO {

    void addBill(Bill bill) throws DAOException, IOException;

    void deleteBill(Bill bill) throws DAOException;

    void replaceBill(Bill a, Bill b) throws DAOException;

    List<Integer> selectExpenses() throws DAOException;
}
