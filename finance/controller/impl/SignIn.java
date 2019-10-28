package by.epam.finance.controller.impl;

import by.epam.finance.bean.AuthorizationInfo;
import by.epam.finance.controller.Command;
import by.epam.finance.sevice.ClientService;
import by.epam.finance.sevice.ServiceException;
import by.epam.finance.sevice.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String login;
        String password;
        String responce;
        if (request.split(" +")[1] != null &&
                request.split(" +")[2] != null) {
            login = request.split(" +")[1];
            password = request.split(" +")[2];
        } else {
            throw new IllegalArgumentException("No login or password has been given.");
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            AuthorizationInfo authorizationInfo = new AuthorizationInfo(login, password);
            clientService.signIn(authorizationInfo);
            responce = "Welcome";
        } catch (ServiceException e) {
            responce = "Login failed.";
        }
        return responce;
    }
}
