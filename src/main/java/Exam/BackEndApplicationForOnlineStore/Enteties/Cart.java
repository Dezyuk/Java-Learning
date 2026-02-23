package Exam.BackEndApplicationForOnlineStore.Enteties;

public interface Cart {
    boolean isEmpty();
    void addProduct(Product productById);
    Product[] getProducts();
    void clear();
}
