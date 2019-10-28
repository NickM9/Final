package by.epam.finance.controller.impl;

import by.epam.finance.bean.Bill;
import by.epam.finance.controller.Command;
import by.epam.finance.sevice.BillService;
import by.epam.finance.sevice.ServiceException;
import by.epam.finance.sevice.ServiceFactory;

public class AddBill implements Command {


    @Override
    public String execute(String request) {
        System.out.println(request);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BillService billService = serviceFactory.getBillService();

        String response = "Failed to add the bill.";

        if (request.split(" +")[1] != null && request.split(" +")[1].matches("[-0-9]+")) {
            try {

                billService.addBill(
                        new Bill(Integer.parseInt(request.split(" +")[1]))
                );
                response = "Bill added.";
                return response;

            } catch (ServiceException e) {
                e.getMessage();
                e.printStackTrace();

            }
        } else {
            try {
                throw new ServiceException("Wrong command format.");
            } catch (ServiceException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
        return response;
    }
}
