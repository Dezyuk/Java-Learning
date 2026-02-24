package Exam.BackEndApplicationForOnlineStore.Enteties.impl;

import Exam.BackEndApplicationForOnlineStore.Enteties.Product;

public class DefaultProduct implements Product {
    private int id;
    private String productName;
    private String categoryName;
    private double price;

    public DefaultProduct() {

    }

    public DefaultProduct(int id, String productName, String categoryName, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override
    public String toString() {
        return "DefaultProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                '}';
    }
}
