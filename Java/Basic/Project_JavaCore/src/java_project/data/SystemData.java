package java_project.data;

import java_project.Utils.IdUtil;
import java_project.entity.*;
import java_project.service.IRoleService;
import java_project.service.Impl.CategoryService;
import java_project.service.Impl.RoleService;

import java.util.ArrayList;
import java.util.List;

public class SystemData {
    public static List<Role> roleData() {
        AbstractId.generateId = IdUtil.checkId(CreateData.roles);
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("Quản trị viên", "ADMIN"));
        roles.add(new Role("Người dùng", "USER"));
        return roles;
    }

    public static List<User> UserData() {
        AbstractId.generateId = IdUtil.checkId(CreateData.users);
        List<User> users = new ArrayList<>();
        IRoleService roleService = new RoleService();
//        Admin
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("123");
        admin.setFullName("Quản trị viên");
        admin.setStatus(1);
        admin.setRoleId(1L);
        admin.setRole(roleService.findRoleById(admin.getRoleId()));
//        User
        User user = new User();
        user.setUsername("tunght");
        user.setPassword("123");
        user.setFullName("Ha Thanh Tung");
        user.setStatus(1);
        user.setRoleId(2L);
        user.setRole(roleService.findRoleById(user.getRoleId()));

        users.add(admin);
        users.add(user);
        return users;
    }

    public static List<Category> categoryData() {
        AbstractId.generateId = IdUtil.checkId(CreateData.categories);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Điện thoại"));
        categories.add(new Category("Laptop"));
        categories.add(new Category("TV"));
        return categories;
    }

    public static List<Product> productData() {
        AbstractId.generateId = IdUtil.checkId(CreateData.products);
        List<Product> products = new ArrayList<>();
        CategoryService categoryService = new CategoryService();
        products.add(new Product("Iphone 12 Pro Max", 30000, 1));
        products.add(new Product("Iphone 11 Pro Max", 20000, 1));
        products.add(new Product("Iphone XR", 15000, 1));
        products.add(new Product("Lenovo Legion Y530", 23000, 2));
        products.add(new Product("Lenovo Legion Y540", 33000, 2));
        products.add(new Product("Lenovo Thinkpad", 30000, 2));
        products.add(new Product("Sony SmartTV 4K 55inch", 30000, 3));
        products.add(new Product("Sony SmartTV 4K 65inch", 35000, 3));
        products.add(new Product("Sony SmartTV 4K 43inch", 25000, 3));
        for (Product product : products) {
            product.setCategory(categoryService.findCategoryById(product.getCategoryId()));
        }
        return products;
    }
}
