package java_project.manager;

import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.Cart;
import java_project.entity.Product;
import java_project.service.ICartService;
import java_project.service.IProductService;
import java_project.service.Impl.CartService;
import java_project.service.Impl.ProductService;

import java.util.List;
import java.util.Scanner;

public class CartManager {
    private final Scanner scanner;
    private final ScannerUtil scannerUtil;
    private final ICartService cartService;
    private final IProductService productService;

    public CartManager() {
        cartService = new CartService();
        productService = new ProductService();
        scanner = new Scanner(System.in);
        scannerUtil = new ScannerUtil();
    }

    public void showCart() {
        Cart cart = cartService.findOneCartOfUser(CreateData.user.getId());
        if (cart == null || cart.getProducts().size() == 0) {
            System.out.println("Không có sản phẩm nào!");
        } else {
            for (Product product : cart.getProducts()) {
                System.out.println(product.toString());
            }
        }
    }

    public void deleteProductFromCart() {
        Cart cart = cartService.findOneCartOfUser(CreateData.user.getId());
        Product product = null;
        if (cart == null || cart.getProducts().size() == 0) {
            System.out.println("Giỏ hàng trống!");
        } else {
            while (true) {
                for (Product pd : cart.getProducts()) {
                    System.out.println(pd.toString());
                }
                long productId = scannerUtil.checkInteger(scanner, "Nhập id sản phẩm muốn xoá:", Constant.ERROR_MESSAGE);
                for (Product pd : cart.getProducts()) {
                    if (pd.getId() == productId) {
                        product = pd;
                    }
                }
                if (product != null) {
                    cartService.removeFromCart(CreateData.user.getId(), product);
                    System.out.println("Xoá sản phẩm thành công!");
                    break;
                } else {
                    System.out.println("Id sản phẩm không có trong giỏ hàng");
                }
            }
        }
    }

    public void addToCart() {
        ScannerUtil scannerUtil = new ScannerUtil();
        long productId;
        Product product;
        while (true) {
            productId = scannerUtil.checkInteger(scanner, "Nhập id sản phẩm muốn thêm vào giỏ hàng",
                    Constant.ERROR_MESSAGE);
            product = productService.findProductById(productId);
            if (product != null) {
                break;
            } else {
                System.out.println("Sản phẩm không tồn tại");
            }
        }
        cartService.addToCart(CreateData.user.getId(), product);
        System.out.println("Thêm vào giỏ hàng thành công!");
    }

    public void addToCartWithCategory(long categoryId) {
        ScannerUtil scannerUtil = new ScannerUtil();
        long productId;
        Product product;
        while (true) {
            productId = scannerUtil.checkInteger(scanner, "Nhập id sản phẩm muốn thêm vào giỏ hàng",
                    Constant.ERROR_MESSAGE);
            product = productService.findProductByIdAndCategoryId(productId, categoryId);
            if (product != null) {
                break;
            } else {
                System.out.println("Sản phẩm không tồn tại");
            }
        }
        cartService.addToCart(CreateData.user.getId(), product);
        System.out.println("Thêm vào giỏ hàng thành công!");
    }
}
