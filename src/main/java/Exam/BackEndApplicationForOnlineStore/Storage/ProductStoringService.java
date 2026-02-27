package Exam.BackEndApplicationForOnlineStore.Storage;

import Exam.BackEndApplicationForOnlineStore.Enteties.Product;

import java.util.List;

public interface ProductStoringService {

    List<Product> loadProducts();

}
