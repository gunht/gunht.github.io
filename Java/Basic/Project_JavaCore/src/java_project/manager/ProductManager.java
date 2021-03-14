package java_project.manager;

import java_project.Utils.*;
import java_project.constant.Constant;
import java_project.entity.AbstractId;
import java_project.entity.Product;
import java_project.service.ICategoryService;
import java_project.service.IProductService;
import java_project.service.Impl.CategoryService;
import java_project.service.Impl.ProductService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private final IProductService productService;
    private final ICategoryService categoryService;
    private final Scanner scanner;
    private final ScannerUtil scannerUtil;

    public ProductManager() {
        productService = new ProductService();
        categoryService = new CategoryService();
        scanner = new Scanner(System.in);
        scannerUtil = new ScannerUtil();
    }

    public void showProductOfCategory(long id) {
        for (Product product : productService.findProductByCategoryId(id)) {
            System.out.println(product.toString());
        }
    }

    public void showAllProducts() {
        List<Product> products = productService.findAll();
        products.sort(new SortProductById());
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void sortProductsByASC() {
        List<Product> products = productService.findAll();
        products.sort(new SortProductByName());
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void sortProductsByDESC() {
        List<Product> products = productService.findAll();
        products.sort(new SortProductByName());
        Collections.reverse(products);
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void sortProductsByPriceASC() {
        List<Product> products = productService.findAll();
        products.sort(new SortProductByPrice());
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void sortProductsByPriceDESC() {
        List<Product> products = productService.findAll();
        products.sort(new SortProductByPrice());
        Collections.reverse(products);
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void searchProductsByName() {
        System.out.println("Nhập tên sản phẩm muốn tìm:");
        String name = scanner.nextLine();
        List<Product> products = productService.findByName(name);
        if (products.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm nào.");
        } else {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public void searchProductsByBiggerPrice() {
        int priceSearch = scannerUtil.checkInteger(scanner, "Nhập giá sản phẩm tìm kiếm:", Constant.ERROR_MESSAGE);
        List<Product> products = productService.findByPrice(priceSearch, Constant.BIGGER_PRICE);
        if (products.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm nào.");
        } else {
            products.sort(new SortProductByPrice());
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public void searchProductsByLesserPrice() {
        int priceSearch = scannerUtil.checkInteger(scanner, "Nhập giá sản phẩm tìm kiếm:", Constant.ERROR_MESSAGE);
        List<Product> products = productService.findByPrice(priceSearch, Constant.LESSER_PRICE);
        if (products.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm nào.");
        } else {
            products.sort(new SortProductByPrice());
            Collections.reverse(products);
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public void addProduct() {
        System.out.println("Tên sản phẩm:");
        String name = scanner.nextLine();
        int price = scannerUtil.checkInteger(scanner, "Giá tiền sản phẩm:", Constant.ERROR_MESSAGE);
        System.out.println(categoryService.findAll().toString());
        int categoryId = scannerUtil.checkInteger(scanner, "Nhập Id danh mục:", Constant.ERROR_MESSAGE);
        AbstractId.generateId = IdUtil.checkId(productService.findAll());
        Product product = productService.saveProduct(new Product(name, price, categoryId));
        if (product == null) {
            System.out.println("Sản phẩm đã tồn tại!");
        } else {
            System.out.println("Thêm sản phẩm thành công!");
        }
    }

    public void updateProduct() {
        for (Product product : productService.findAll()) {
            System.out.println(product.toString());
        }
        int productId = scannerUtil.checkInteger(scanner, "Nhập id sản phẩm muốn sủa:", Constant.ERROR_MESSAGE);
        Product product = productService.findProductById(productId);
        if (product == null) {
            System.out.println("Sản phẩm không tồn tại!");
            return;
        }
        System.out.println("Nhập tên muốn sửa: (để trống nếu không muốn sửa đổi)");
        String name = scanner.nextLine();
        int price = scannerUtil.checkInteger(scanner, "Nhập giá muốn sửa:", Constant.ERROR_MESSAGE);
        if (!name.equals("")) {
            product.setName(name);
        }
        product.setPrice(price);
        productService.updateProduct(productId - 1, product);
        System.out.println("Sửa đổi sản phẩm thành công!");
    }
}
