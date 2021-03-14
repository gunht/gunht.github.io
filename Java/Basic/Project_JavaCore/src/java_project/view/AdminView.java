package java_project.view;

import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.Category;
import java_project.manager.CategoryManager;
import java_project.manager.OrderManager;
import java_project.manager.ProductManager;
import java_project.manager.UserManager;

import java.util.Scanner;

public class AdminView {
    private final Scanner scanner = new Scanner(System.in);
    private final ScannerUtil scannerUtil = new ScannerUtil();
    private final UserManager userManager = new UserManager();
    private final ProductManager productManager = new ProductManager();
    private final OrderManager orderManager = new OrderManager();
    private final CategoryManager categoryManager = new CategoryManager();


    public void showAdminView() {
        boolean isValid = true;
        while (isValid) {
            MenuView.adminView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> showUserManagerView();
                case 2 -> showProductManagerView();
                case 3 -> showOrderManagerView();
                case 0 -> {
                    CreateData.user = null;
                    isValid = false;
                }
                default -> System.out.println("Vui lòng chọn chính xác.");
            }
        }
    }

    private void showUserManagerView() {
        boolean isValid = true;
        while (isValid) {
            MenuView.userManagerView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> showListUserManagerView();
                case 2 -> userManager.searchUsers();
                case 3 -> userManager.removeUser();
                case 4 -> userManager.activeUser();
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác.");
            }
        }
    }

    private void showListUserManagerView() {
        boolean isValid = true;
        while (isValid) {
            MenuView.listUsersView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> userManager.showAllUsers();
                case 2 -> userManager.showUserActive();
                case 3 -> userManager.showUserNonActive();
                case 0 -> {
                    CreateData.user = null;
                    isValid = false;
                }
                default -> System.out.println("Vui lòng chọn chính xác.");
            }
        }
    }

    private void showProductManagerView() {
        boolean isValid = true;
        while (isValid) {
            MenuView.productManagerView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> productManager.addProduct();
                case 2 -> categoryManager.addCategory();
                case 3 -> productManager.updateProduct();
                case 4 -> categoryManager.updateCategory();
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác.");
            }
        }
    }

    private void showOrderManagerView() {
        boolean isValid = true;
        while (isValid) {
            MenuView.orderManagerView();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> orderManager.showAllOrder();
                case 2 -> {
                    if (orderManager.showStatusOrder(Constant.ORDER_STATUS_PENDING).size() > 0) {
                        showSubOrderManager("Xác nhận đơn hàng", Constant.ORDER_STATUS_PENDING, Constant.ORDER_STATUS_CONFIRMED);
                    }
                }
                case 3 -> {
                    if (orderManager.showStatusOrder(Constant.ORDER_STATUS_CONFIRMED).size() > 0) {
                        showSubOrderManager("Xác nhận giao hàng thành công.", Constant.ORDER_STATUS_CONFIRMED, Constant.ORDER_STATUS_COMPLETED);
                    }
                }
                case 4 -> orderManager.showStatusOrder(Constant.ORDER_STATUS_COMPLETED);
                case 5 -> orderManager.showStatusOrder(Constant.ORDER_STATUS_CANCELED);
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác.");
            }
        }
    }

    private void showSubOrderManager(String message, int status, int changeStatus) {
        boolean isValid = true;
        while (isValid) {
            MenuView.subOrderManagerView(message);
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> {
                    orderManager.confirmOrder(message, status, changeStatus);
                    isValid = false;
                }
                case 2 -> {
                    orderManager.confirmOrder("Huỷ đơn hàng", status, -1);
                    isValid = false;
                }
                case 0 -> isValid = false;
                default -> System.out.println("Vui lòng chọn chính xác.");
            }
        }
    }
}
