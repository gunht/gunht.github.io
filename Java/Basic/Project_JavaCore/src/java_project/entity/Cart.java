package java_project.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AbstractId {
    private long userId;
    private User user;
    private List<Product> products = new ArrayList<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
