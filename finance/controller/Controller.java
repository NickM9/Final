package by.epam.finance.controller;

import by.epam.finance.bean.User;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private final char delimiter = ' ';

    public String execute(String request) {
        request = request.trim();
        if (request.indexOf(delimiter) == -1) {
            Command executionCommand = commandProvider.getCommand(request);
            return executionCommand.execute(request);

        }
        String commandName = request.substring(0, request.indexOf(delimiter));
        Command executionCommand = commandProvider.getCommand(commandName);
        return executionCommand.execute(request);
    }

    public String execute(String request, User user) {
        request = request.trim();
        String commandName = request.substring(0, request.indexOf(delimiter));
        Command executionCommand = commandProvider.getCommand(commandName);
        String response = executionCommand.execute(request);
        if (response.equalsIgnoreCase("Welcome")) {
            user.setLoggedIn(true);
        }
        return response;
    }
}
