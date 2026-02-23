package Exam.BackEndApplicationForOnlineStore.Services;

import Exam.BackEndApplicationForOnlineStore.Enteties.Order;

public interface OrderManagementService {
    void addOrder(Order order);
    Order[] getOrdersByUserId(int userId);
    Order[] getOrders();

}
