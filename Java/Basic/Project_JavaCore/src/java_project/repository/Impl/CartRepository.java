package java_project.repository.Impl;

import java_project.data.CreateData;
import java_project.entity.Cart;
import java_project.entity.Product;
import java_project.repository.ICartRepository;
import java_project.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class CartRepository implements ICartRepository {

    private final IUserRepository userRepository = new UserRepository();

    @Override
    public Cart findCartOfUser(long userId) {
        for (Cart cart : CreateData.carts) {
            if (cart.getUserId() == userId) {
                return cart;
            }
        }
        return null;
    }

    @Override
    public List<Product> addToCart(long userId, Product product) {
        Cart cart = findCartOfUser(userId);
        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            newCart.setUser(userRepository.findUserById(userId));
            newCart.getProducts().add(product);
            CreateData.carts.add(newCart);
            return findCartOfUser(userId).getProducts();
        } else {
            cart.getProducts().add(product);
        }
        return cart.getProducts();
    }

    @Override
    public List<Product> removeFromCart(long userId, Product product) {
        Cart cart = findCartOfUser(userId);
        if (cart != null) {
            cart.getProducts().remove(product);
            return cart.getProducts();
        }
        return null;
    }

    @Override
    public void removeCart(long userId) {
        for (Cart cart : CreateData.carts) {
            if (cart.getUserId() == userId) {
                cart.setProducts(new ArrayList<>());
            }
        }
    }
}
