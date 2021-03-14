package java_project.data;

import java_project.entity.*;

import java.util.ArrayList;
import java.util.List;

public class CreateData {
    public static List<Role> roles = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Cart> carts = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static User user;

    public static void initData() {
        roles = SystemData.roleData();
        users = SystemData.UserData();
        categories = SystemData.categoryData();
        products = SystemData.productData();
    }
}
