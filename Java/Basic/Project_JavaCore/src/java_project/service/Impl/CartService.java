package java_project.service.Impl;

import java_project.entity.Cart;
import java_project.entity.Product;
import java_project.repository.ICartRepository;
import java_project.repository.Impl.CartRepository;
import java_project.service.ICartService;

import java.util.List;

public class CartService implements ICartService {
    private final ICartRepository cartRepository;

    public CartService() {
        cartRepository = new CartRepository();
    }


    @Override
    public Cart findOneCartOfUser(long userId) {
        return cartRepository.findCartOfUser(userId);
    }

    @Override
    public List<Product> addToCart(long userId, Product product) {
        return cartRepository.addToCart(userId, product);
    }

    @Override
    public List<Product> removeFromCart(long userId, Product product) {
        return cartRepository.removeFromCart(userId, product);
    }

    @Override
    public void removeCart(long userId) {
        cartRepository.removeCart(userId);
    }
}
