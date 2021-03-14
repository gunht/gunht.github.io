package java_project.repository.Impl;

import java_project.data.CreateData;
import java_project.entity.Order;
import java_project.repository.IOrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {

    @Override
    public List<Order> findAll() {
        return CreateData.orders;
    }

    @Override
    public Order findById(long id) {
        for (Order order : findAll()) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long userId) {
        List<Order> orders = findAll();
        List<Order> newOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId() == userId) {
                newOrders.add(order);
            }
        }
        return newOrders;
    }

    @Override
    public List<Order> findByStatus(int status) {
        List<Order> newOrders = new ArrayList<>();
        for (Order order : findAll()) {
            if (order.getStatus() == status) {
                newOrders.add(order);
            }
        }
        return newOrders;
    }

    @Override
    public Order add(Order order) {
        List<Order> orders = findAll();
        orders.add(order);
        return orders.get(orders.size() - 1);
    }

    @Override
    public Order update(int index, Order order) {
        List<Order> orders = findAll();
        orders.set(index, order);
        return null;
    }
}
