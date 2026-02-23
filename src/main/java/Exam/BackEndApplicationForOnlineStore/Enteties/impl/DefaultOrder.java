package Exam.BackEndApplicationForOnlineStore.Enteties.impl;

import Exam.BackEndApplicationForOnlineStore.Enteties.Order;
import Exam.BackEndApplicationForOnlineStore.Enteties.Product;


public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private int customerId;
    private Product[] products;
    private String userInput;

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        return userInput.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER && !userInput.contains(" ") && Long.parseLong(userInput) > 0;
    }

    @Override
    public void setCreditCardNumber(String userInput) {
        if (userInput == null) {
            return;
        }
        this.userInput = userInput;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }
}
