package by.epam.finance.sevice;

import by.epam.finance.sevice.impl.BillServiceImpl;
import by.epam.finance.sevice.impl.ClientServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final BillService billService = new BillServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public BillService getBillService() {
        return billService;
    }
}
