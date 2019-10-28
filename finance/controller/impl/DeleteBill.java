package by.epam.finance.controller.impl;

import by.epam.finance.bean.Bill;
import by.epam.finance.controller.Command;
import by.epam.finance.sevice.BillService;
import by.epam.finance.sevice.ServiceException;
import by.epam.finance.sevice.ServiceFactory;

public class DeleteBill implements Command {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private BillService billService = serviceFactory.getBillService();

    @Override
    public String execute(String request) {
        String response = "Failed to delete.";
        if (request.split(" +")[1] != null && request.split(" +")[1].matches("[-0-9]+")) {
            try {
                billService.deleteBill(
                        new Bill(Integer.parseInt(request.split(" +")[1]))
                );
                response = "Deleted successfully";
            } catch (ServiceException e) {
                response = e.getMessage();
            }
        }
        return response;
    }
}
