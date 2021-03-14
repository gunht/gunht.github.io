package java_project.manager;

import java_project.Utils.IdUtil;
import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.AbstractId;
import java_project.entity.Cart;
import java_project.entity.Order;
import java_project.entity.Product;
import java_project.service.ICartService;
import java_project.service.IOrderService;
import java_project.service.IProductService;
import java_project.service.Impl.CartService;
import java_project.service.Impl.OrderService;
import java_project.service.Impl.ProductService;
import java_project.view.MenuView;

import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private final Scanner scanner;
    private final ScannerUtil scannerUtil;
    private final ICartService cartService;
    private final IProductService productService;
    private final IOrderService orderService;

    public OrderManager() {
        scanner = new Scanner(System.in);
        scannerUtil = new ScannerUtil();
        cartService = new CartService();
        productService = new ProductService();
        orderService = new OrderService();
    }

    public long showCart() {
        Cart cart = cartService.findOneCartOfUser(CreateData.user.getId());
        int totalPrice = 0;
        if (cart != null && cart.getProducts().size() > 0) {
            for (Product product : cart.getProducts()) {
                System.out.println(product.toString());
                totalPrice += product.getPrice();
            }
            System.out.println("Tổng tiền: " + totalPrice + "đ");
        }
        return totalPrice;
    }

    public void showOrderFromUser() {
        List<Order> orders = orderService.findByUserId(CreateData.user.getId());
        if (orders.size() > 0) {
            for (Order order : orders) {
                fillOrder(order);
            }
        } else {
            System.out.println("Không có đơn hàng nào!");
        }

    }

    public void addToOrder() {
        String choice;
        while (true) {
            System.out.println("Bạn có muốn đặt hàng? (Y/n):");
            choice = scanner.nextLine();
            if (choice.toLowerCase().equals("y")) {
                System.out.println("Nhập địa chỉ giao hàng:");
                String address = scanner.nextLine();
                Cart cart = cartService.findOneCartOfUser(CreateData.user.getId());
                AbstractId.generateId = IdUtil.checkId(orderService.findAll());
                Order order = new Order();
                order.setUserId(cart.getUserId());
                order.setUser(cart.getUser());
                order.setAddress(address);
                order.setStatus(Constant.ORDER_STATUS_PENDING);
                order.setProducts(cart.getProducts());
                order.setTotalPrice(showCart());
                orderService.add(order);
                cartService.removeCart(CreateData.user.getRoleId());
                System.out.println("Đặt hàng thành công!");
                break;
            } else if (choice.toLowerCase().equals("n")) {
                System.out.println("Huỷ đặt hàng.");
                break;
            } else {
                System.out.println("Vui lòng nhập chính xác.");
            }
        }
    }

    public void showAllOrder() {
        List<Order> orders = orderService.findAll();
        if (orders.size() <= 0) {
            System.out.println("Không có đơn hàng nào!");
            return;
        }
        for (Order order : orders) {
            fillOrder(order);
        }
    }

    public List<Order> showStatusOrder(int status) {
        List<Order> orders = orderService.findByStatus(status);
        if (orders.size() <= 0) {
            System.out.println("Không có đơn hàng nào!");
        } else {
            for (Order order : orders) {
                fillOrder(order);
            }
        }
        return orders;
    }

    public void confirmOrder(String message, int status, int changeStatus) {
        int orderId = scannerUtil.checkInteger(scanner, "Nhập id đơn hàng:", Constant.ERROR_MESSAGE);
        Order order = orderService.findById(orderId);
        if (order == null || order.getStatus() != status || order.getStatus() == 2 || order.getStatus() == -1) {
            System.out.println("Id đơn hàng không đúng!");
            return;
        }
        System.out.println(order.getProducts().toString());
        System.out.println("Giá: " + order.getTotalPrice() + "đ");
        System.out.println("");
        while (true) {
            System.out.println("Bạn có muốn " + message + "? (Y/n):");
            String choice = scanner.nextLine();
            if (choice.toLowerCase().equals("y")) {
                order.setStatus(changeStatus);
                System.out.println(message + " thành công!");
                return;
            } else if (choice.toLowerCase().equals("n")) {
                System.out.println("Không " + message + ".");
                return;
            } else {
                System.out.println("Vui lòng nhập lại.");
            }
        }
    }

    private void fillOrder(Order order) {
        System.out.println("Id: " + order.getId());
        System.out.println(order.getProducts());
        System.out.println("Giá tiền đơn hàng: " + order.getTotalPrice() + "đ");
        System.out.println("Địa chỉ giao hàng: " + order.getAddress());
        switch (order.getStatus()) {
            case Constant.ORDER_STATUS_PENDING -> System.out.println("Trạng thái: Đang chờ xác nhận.");
            case Constant.ORDER_STATUS_CONFIRMED -> System.out.println("Trạng thái: Đang giao hàng.");
            case Constant.ORDER_STATUS_COMPLETED -> System.out.println("Trạng thái: Đã giao hàng thành công.");
            case Constant.ORDER_STATUS_CANCELED -> System.out.println("Trạng thái: Đã huỷ.");
        }
    }
}
