package by.epam.finance.controller.impl;

import by.epam.finance.controller.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong request.";
    }
}
