package java_project.view;

import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.manager.CartManager;
import java_project.manager.CategoryManager;
import java_project.manager.OrderManager;
import java_project.manager.ProductManager;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);
    private final ScannerUtil scannerUtil = new ScannerUtil();
    private final CartManager cartManager = new CartManager();
    private final CategoryManager categoryManager = new CategoryManager();
    private final ProductManager productManager = new ProductManager();
    private final OrderManager orderManager = new OrderManager();

    public void showUserView() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> showCategoryMenu();
                case 2 -> showProductMenu();
                case 3 -> showSearchMenu();
                case 4 -> ShowCartMenu();
                case 5 -> showOrderMenu();
                case 0 -> {
                    CreateData.user = null;
                    isValid = false;
                }
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void showCategoryMenu() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userCategoryView();
            categoryManager.showCategory();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            if (choice >= 1 && choice <= categoryManager.amountOfCategories().size()) {
                productManager.showProductOfCategory(choice);
                addToCartWithCategory(choice);
            } else if (choice == 0) {
                isValid = false;
            } else {
                System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void showProductMenu() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userProductView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> {
                    productManager.showAllProducts();
                    addToCart();
                }
                case 2 -> {
                    productManager.sortProductsByASC();
                    addToCart();
                }
                case 3 -> {
                    productManager.sortProductsByDESC();
                    addToCart();
                }
                case 4 -> {
                    productManager.sortProductsByPriceASC();
                    addToCart();
                }
                case 5 -> {
                    productManager.sortProductsByPriceDESC();
                    addToCart();
                }
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void showSearchMenu() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userSearchView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> {
                    productManager.searchProductsByName();
                    addToCart();
                }
                case 2 -> {
                    productManager.searchProductsByBiggerPrice();
                    addToCart();
                }
                case 3 -> {
                    productManager.searchProductsByLesserPrice();
                    addToCart();
                }
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void ShowCartMenu() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userCartView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> cartManager.showCart();
                case 2 -> cartManager.deleteProductFromCart();
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void showOrderMenu() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userOrderView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> {
                    if (orderManager.showCart() > 0) {
                        addToOrder();
                    } else {
                        System.out.println("Không có sản phẩm nào!");
                    }
                }
                case 2 -> orderManager.showOrderFromUser();
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void addToCart() {
        boolean isValid = true;
        while (isValid) {
            MenuView.addToCartView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> cartManager.addToCart();
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void addToCartWithCategory(long categoryId) {
        boolean isValid = true;
        while (isValid) {
            MenuView.addToCartView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> cartManager.addToCartWithCategory(categoryId);
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void addToOrder() {
        boolean isValid = true;
        while (isValid) {
            MenuView.addToOrderView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1:
                    orderManager.addToOrder();
                case 0:
                    isValid = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn chính xác");
            }
        }
    }
}
