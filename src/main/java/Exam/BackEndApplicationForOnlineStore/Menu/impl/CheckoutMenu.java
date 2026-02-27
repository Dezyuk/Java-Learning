package Exam.BackEndApplicationForOnlineStore.Menu.impl;

import Exam.BackEndApplicationForOnlineStore.Configs.ApplicationContext;
import Exam.BackEndApplicationForOnlineStore.Enteties.Order;
import Exam.BackEndApplicationForOnlineStore.Enteties.impl.DefaultOrder;
import Exam.BackEndApplicationForOnlineStore.Menu.Menu;
import Exam.BackEndApplicationForOnlineStore.Services.OrderManagementService;
import Exam.BackEndApplicationForOnlineStore.Services.impl.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckoutMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }
    @Override
    public void start() {
        while (true){
            printMenuHeader();
            Scanner sc = new Scanner(System.in);

            String userInput = sc.next();
            if (!createOrder(userInput)) {
                continue;
            }
            context.getSessionCart().clear();
            break;

        }
        System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
        new MainMenu().start();
    }

    private boolean createOrder(String userInput) {
        Order order = new DefaultOrder();
        if(!order.isCreditCardNumberValid(userInput)){
            return false;
        }
        order.setCreditCardNumber(userInput);
        order.setProducts(context.getSessionCart().getProducts());
        order.setCustomerId(context.getLoggedInUser().getId());
        orderManagementService.addOrder(order);
        return true;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHECKOUT *****");
        System.out.print(
                "Enter your credit card number without spaces and press enter if you confirm purchase: ");
    }
}
