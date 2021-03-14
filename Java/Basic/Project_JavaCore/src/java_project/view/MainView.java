package java_project.view;

import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.User;
import java_project.manager.UserManager;

import java.util.Scanner;

public class MainView {

    public void openPrograming() {
        Scanner scanner = new Scanner(System.in);
        ScannerUtil scannerUtil = new ScannerUtil();
        UserManager userManager = new UserManager();
        while (true) {
            MenuView.loginMenu();
            int choice = scannerUtil.checkInteger(scanner, Constant.CHOICE, Constant.ERROR_MESSAGE);
            switch (choice) {
                case 1 -> { //Dang nhap
                    User user = userManager.checkLogin();
                    if (user != null) {
                        System.out.println("Đăng nhập thành công!");
                        System.out.println("Xin chào " + user.getFullName() + "!");
                        CreateData.user = user;
                        authorization(user);
                    } else {
                        System.out.println("Kiểm tra lại Username hoặc Password!");
                    }
                }
                case 2 -> userManager.register(); //Dang ky
                case 0 -> System.exit(0); //Thoat chuong trinh
                default -> System.out.println("Vui lòng chọn chính xác");
            }
        }
    }

    private void authorization(User user) {
        AdminView adminView = new AdminView();
        UserView userView = new UserView();
        String roleName = user.getRole().getCode();
        if (roleName.equals(Constant.ROLE_ADMIN)) {
            adminView.showAdminView();
        } else {
            userView.showUserView();
        }
    }
}
