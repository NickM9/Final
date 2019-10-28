package by.epam.finance;

import by.epam.finance.bean.User;
import by.epam.finance.controller.Controller;

public class Main {
    public static void main(String[] args) {

        User nick = new User("N2M2");

        Controller controller = new Controller();

        String response = controller.execute("SIGN_IN login password", nick);
        System.out.println(response);
        if (response.equalsIgnoreCase("Welcome")) {
            String responseAddBill = controller.execute("ADD_BILL  400");
            System.out.println(responseAddBill);

            String responseAddBill1 = controller.execute("ADD_BILL 1200");
            System.out.println(responseAddBill1);

            String responseAddBill2 = controller.execute("ADD_BILL -800");
            System.out.println(responseAddBill2);

            String responseAddBill3 = controller.execute("ADD_BILL -200");
            System.out.println(responseAddBill3);

            String responseCalculateExpenses = controller.execute("CALCULATE_EXPENSES");
            System.out.println(responseCalculateExpenses);


            String responseReplaceBill = controller.execute("REPLACE_BILL 400 600");
            System.out.println(responseReplaceBill);


            String responseDeleteBill = controller.execute("DELETE_BILL 1200");
            System.out.println(responseDeleteBill);
        }

    }
}
