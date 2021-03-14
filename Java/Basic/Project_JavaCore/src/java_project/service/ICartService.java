package java_project.service;

import java_project.entity.Cart;
import java_project.entity.Product;

import java.util.List;

public interface ICartService {
    Cart findOneCartOfUser(long userId);
    List<Product> addToCart(long userId, Product product);
    List<Product> removeFromCart(long userId, Product product);
    void removeCart(long userId);
}
