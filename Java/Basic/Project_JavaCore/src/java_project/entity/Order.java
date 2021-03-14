package java_project.entity;

import java.util.ArrayList;
import java.util.List;

public class Order extends AbstractId {
    private long userId;
    private User user;
    private List<Product> products;
    private long totalPrice;
    private String address;
    private int status;

    public Order() {
        products = new ArrayList<>();
    }

    public Order(long userId, User user, List<Product> products, long totalPrice, String address, int status) {
        this.userId = userId;
        this.user = user;
        this.products = products;
        this.totalPrice = totalPrice;
        this.address = address;
        this.status = status;
    }

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

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
