package java_project.service.Impl;

import java_project.entity.Order;
import java_project.repository.IOrderRepository;
import java_project.repository.Impl.OrderRepository;
import java_project.service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findByUserId(long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> findByStatus(int status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Order add(Order order) {
        return orderRepository.add(order);
    }

    @Override
    public Order update(int index, Order order) {
        return orderRepository.update(index, order);
    }
}
