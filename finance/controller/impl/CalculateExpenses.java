package by.epam.finance.controller.impl;

import by.epam.finance.controller.Command;
import by.epam.finance.sevice.BillService;
import by.epam.finance.sevice.ServiceException;
import by.epam.finance.sevice.ServiceFactory;

public class CalculateExpenses implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BillService billService = serviceFactory.getBillService();
        String response = null;
        try {
            response = String.valueOf(billService.calculateExpenses());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println(request);
        return response;
    }
}
