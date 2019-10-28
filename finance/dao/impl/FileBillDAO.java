package by.epam.finance.dao.impl;

import by.epam.finance.bean.Bill;
import by.epam.finance.dao.BillDAO;
import by.epam.finance.dao.DAOException;
import by.epam.finance.sevice.util.FinInfoReader;
import by.epam.finance.sevice.util.FinInfoWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBillDAO implements BillDAO {
    private FinInfoWriter finInfoWriter = new FinInfoWriter("./src/by/epam/finance/Data.txt");

    private FinInfoReader finInfoReader = new FinInfoReader("./src/by/epam/finance/Data.txt");

    @Override
    public void addBill(Bill bill) throws DAOException, IOException {
        finInfoWriter.prepareWriter(true);
        finInfoWriter.writeNote(bill.getSum());
        finInfoWriter.writerFlush();
        finInfoWriter.close();

    }

    @Override
    public void deleteBill(Bill bill) throws DAOException {
        StringBuilder sb = new StringBuilder();
        String s;
        boolean isFound = false;
        try {
            finInfoReader.resetReader();
            while ((s = finInfoReader.readNote()) != null) {
                if (!s.equalsIgnoreCase(String.valueOf(bill.getSum()))) {
                    sb.append(s).append("\r\n");
                } else {
                    isFound = true;
                }

            }
            finInfoReader.close();
            if (isFound) {
                finInfoWriter.replaceAllFile(sb.toString());
            } else {
                throw new DAOException("Nothing to delete");
            }
        } catch (IOException e1) {
            throw new DAOException();
        }
    }

    @Override
    public void replaceBill(Bill a, Bill b) throws DAOException {
        StringBuilder sb = new StringBuilder();
        String s;
        boolean isFound = false;
        try {
            finInfoReader.resetReader();
            while ((s = finInfoReader.readNote()) != null) {
                if (s.equalsIgnoreCase(Integer.toString(a.getSum()))) {
                    isFound = true;
                    sb.append(s.replace(Integer.toString(a.getSum()), Integer.toString(b.getSum()))).append("\r\n");
                } else {
                    sb.append(s).append("\r\n");
                }

            }
            finInfoReader.close();
            if (isFound) {
                finInfoWriter.replaceAllFile(sb.toString());
            } else {
                throw new DAOException("Nothing to replace");
            }

        } catch (IOException e1) {
            throw new DAOException();
        }
    }

    @Override
    public List<Integer> selectExpenses() throws DAOException {
        List<Integer> expensesList = new ArrayList<>();
        String s;
        try {
            finInfoReader.resetReader();
            while ((s = finInfoReader.readNote()) != null)
                if (Integer.parseInt(s) < 0) {
                    expensesList.add(Integer.parseInt(s));
                }
            finInfoWriter.close();
        } catch (IOException e) {
            throw new DAOException();
        }
        return expensesList;
    }
}
