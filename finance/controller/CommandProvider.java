package by.epam.finance.controller;

import by.epam.finance.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.CALCULATE_EXPENSES, new CalculateExpenses());
        repository.put(CommandName.ADD_BILL, new AddBill());
        repository.put(CommandName.DELETE_BILL, new DeleteBill());
        repository.put(CommandName.REPLACE_BILL, new ReplaceBill());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
