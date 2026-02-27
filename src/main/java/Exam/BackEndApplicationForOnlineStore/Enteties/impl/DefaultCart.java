package Exam.BackEndApplicationForOnlineStore.Enteties.impl;

import Exam.BackEndApplicationForOnlineStore.Enteties.Cart;
import Exam.BackEndApplicationForOnlineStore.Enteties.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultCart implements Cart {
    private List<Product> products;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
//		return Collections.unmodifiableList(this.products); // returns unmodifiable List
        return this.products;
    }

    @Override
    public void clear() {
        products.clear();
    }
}
