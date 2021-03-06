package java_project.service;

import java_project.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    List<Order> findByUserId(long id);
    List<Order> findByStatus(int status);
    Order findById(long orderId);
    Order add(Order order);
    Order update(int index, Order order);
}
