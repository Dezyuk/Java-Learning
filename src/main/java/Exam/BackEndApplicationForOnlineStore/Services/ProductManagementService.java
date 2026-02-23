package Exam.BackEndApplicationForOnlineStore.Services;

import Exam.BackEndApplicationForOnlineStore.Enteties.Product;

public interface ProductManagementService {
    Product[] getProducts();
    Product getProductById(int productIdToAddToCart);

}
