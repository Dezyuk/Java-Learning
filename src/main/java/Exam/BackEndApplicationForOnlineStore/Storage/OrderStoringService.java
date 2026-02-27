package Exam.BackEndApplicationForOnlineStore.Storage;

import Exam.BackEndApplicationForOnlineStore.Enteties.Order;

import java.util.List;

public interface OrderStoringService {
    void saveOrders(List<Order> orders);
    List<Order> loadOrders();
}
