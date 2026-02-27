package Exam.BackEndApplicationForOnlineStore.Services;

import Exam.BackEndApplicationForOnlineStore.Enteties.Product;

import java.util.List;

public interface ProductManagementService {
    List<Product> getProducts();

    Product getProductById(int productIdToAddToCart);


}
