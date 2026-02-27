package Exam.BackEndApplicationForOnlineStore.Services.impl;

import Exam.BackEndApplicationForOnlineStore.Enteties.Order;
import Exam.BackEndApplicationForOnlineStore.Enteties.User;
import Exam.BackEndApplicationForOnlineStore.Services.OrderManagementService;
import Exam.BackEndApplicationForOnlineStore.Storage.OrderStoringService;
import Exam.BackEndApplicationForOnlineStore.Storage.impl.DefaultOrderStoringService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DefaultOrderManagementService implements OrderManagementService {


    private static DefaultOrderManagementService instance;
    private List<Order> orders;
    private OrderStoringService orderStoringService;

    {
        orderStoringService = DefaultOrderStoringService.getInstance();
        orders = orderStoringService.loadOrders();

    }

    public DefaultOrderManagementService() {
    }

    public static DefaultOrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) {
            return;
        }
        orders.add(order);
        orderStoringService.saveOrders(orders);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderStoringService.loadOrders().stream()
                .filter(Objects::nonNull)
                .filter(order -> order.getCustomerId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrders() {
        if (orders == null || orders.size() == 0) {
            orders = orderStoringService.loadOrders();
        }
        return this.orders;
    }

    void clearServiceState() {

        orders.clear();
    }
}
