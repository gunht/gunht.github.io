package java_project.manager;

import java_project.Utils.IdUtil;
import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.AbstractId;
import java_project.entity.User;
import java_project.service.IUserService;
import java_project.service.Impl.UserService;

import java.util.List;
import java.util.Scanner;

public class UserManager {
    private final IUserService userService;
    private final Scanner scanner;
    private final ScannerUtil scannerUtil;

    public UserManager() {
        userService = new UserService();
        scanner = new Scanner(System.in);
        scannerUtil = new ScannerUtil();
    }

    public void register() {
        System.out.println("Nhập tên đăng nhập:");
        String userName = scanner.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = scanner.nextLine();
        System.out.println("Nhập lại mật khẩu:");
        String confirmPassword = scanner.nextLine();
        System.out.println("Nhập tên đầy đủ:");
        String fullName = scanner.nextLine();
        if (!password.equals(confirmPassword)) {
            System.out.println("Mật khẩu không khớp nhau!");
            return;
        }
        AbstractId.generateId = IdUtil.checkId(CreateData.users);
        User user = userService.saveUser(
                new User(userName, password, fullName, Constant.STATUS_ACTIVE, 2L)
        );
        if (user == null) {
            System.out.println("Tên đăng nhập đã tồn tại!");
        } else {
            System.out.println("Đăng ký thành công");
        }
    }

    public User checkLogin() {
        System.out.println("Nhập tên đăng nhập:");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = scanner.nextLine();
        return userService.FindByUserNameAndPassword(username, password, Constant.STATUS_ACTIVE);
    }

    public void showAllUsers() {
        for (User user : userService.findAll()) {
            System.out.println(user.toString());
        }
    }

    public void showUserActive() {
        for (User user : userService.findAll()) {
            if (user.getStatus() == Constant.STATUS_ACTIVE) {
                System.out.println(user.toString());
            }
        }
    }

    public void showUserNonActive() {
        int count = 0;
        for (User user : userService.findAll()) {
            if (user.getStatus() == Constant.STATUS_NON_ACTIVE) {
                System.out.println(user.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có User chưa active!");
        }
    }

    public void searchUsers() {
        System.out.println("Nhập tên user muốn tìm:");
        String name = scanner.nextLine();
        List<User> users = userService.findByUserName(name);
        if (users.size() > 0) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Không tìm thấy user nào!");
        }
    }

    public void removeUser() {
        showUserActive();
        int userId = scannerUtil.checkInteger(scanner, "Nhập id user muốn xoá:", Constant.ERROR_MESSAGE);
        User user = userService.findUserById(userId);
        if (user != null) {
            if (user.getStatus() == Constant.STATUS_NON_ACTIVE) {
                System.out.println("User đã được xoá rồi!");
                return;
            }
            userService.removeUser(userId);
            System.out.println("Đã xoá thành công User!");
        } else {
            System.out.println("User không tồn tại!");
        }
    }

    public void activeUser() {
        showUserNonActive();
        int userId = scannerUtil.checkInteger(scanner, "Nhập id user muốn active:", Constant.ERROR_MESSAGE);
        User user = userService.findUserById(userId);
        if (user != null) {
            if (user.getStatus() == Constant.STATUS_ACTIVE) {
                System.out.println("User đã được active rồi!");
                return;
            }
            userService.activeUser(userId);
            System.out.println("Đã active thành công User!");
        } else {
            System.out.println("User không tồn tại!");
        }
    }
}
