package by.epam.finance.sevice;

import by.epam.finance.bean.Bill;

public interface BillService {

    void addBill(Bill bill) throws ServiceException;

    void replaceBill(Bill a, Bill b) throws ServiceException;

    void deleteBill(Bill bill) throws ServiceException;

    int calculateExpenses() throws ServiceException;


}
