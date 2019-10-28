package by.epam.finance.controller.impl;

import by.epam.finance.bean.Bill;
import by.epam.finance.controller.Command;
import by.epam.finance.sevice.BillService;
import by.epam.finance.sevice.ServiceException;
import by.epam.finance.sevice.ServiceFactory;

public class ReplaceBill implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private BillService billService = serviceFactory.getBillService();

    @Override
    public String execute(String request) {
        String response = "Wrong command format.";
        if (request.split(" +")[1] != null && request.split(" +")[1].matches("[-0-9]+") &&
                request.split(" +")[2] != null && request.split(" +")[2].matches("[-0-9]+")) {
            String first = request.split(" +")[1];
            String second = request.split(" +")[2];
            try {
                billService.replaceBill(new Bill(Integer.parseInt(first)), new Bill(Integer.parseInt(second)));
                response = "Replaced successfully";

            } catch (ServiceException e) {
                response = e.getMessage();
            }
        }
        return response;
    }
}
