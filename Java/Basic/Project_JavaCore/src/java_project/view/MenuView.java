package java_project.view;

public class MenuView {
    public static void loginMenu() {
        System.out.println("---------- Đăng nhập ----------");
        System.out.println("1. Đăng nhập.");
        System.out.println("2. Đăng ký.");
        System.out.println("0. Thoát chương trình.");
    }

    public static void userView() {
        System.out.println("---------- Người dùng ----------");
        System.out.println("1. Hiển thị danh mục sản phẩm.");
        System.out.println("2. Hiển thị tất cả sản phẩm.");
        System.out.println("3. Tìm kiếm sản phẩm.");
        System.out.println("4. Giỏ hàng.");
        System.out.println("5. Đặt hàng.");
        System.out.println("0. Đăng xuất.");
    }

    public static void userCategoryView() {
        System.out.println("---------- Người dùng -> Hiển thị danh mục sản phẩm ----------");
    }

    public static void userProductView() {
        System.out.println("---------- Người dùng -> Hiển thị danh sách sản phẩm ----------");
        System.out.println("1. Hiển thị danh sách sản phẩm.");
        System.out.println("2. Hiển thị danh sách sản phẩm theo thứ tự (ABC)");
        System.out.println("3. Hiển thị danh sách sản phẩm theo thứ tự (CBA)");
        System.out.println("4. Hiển thị danh sách sản phẩm theo giá tiền từ thấp lên cao.");
        System.out.println("5. Hiển thị danh sách sản phẩm theo giá tiền từ cao xuống thấp.");
        System.out.println("0. Quay lại.");
    }

    public static void userSearchView() {
        System.out.println("---------- Người dùng -> Tìm kiếm sản phẩm ----------");
        System.out.println("1. Tìm kiếm theo tên sản phẩm.");
        System.out.println("2. Tìm kiếm theo giá sản phẩm (Lớn hơn).");
        System.out.println("3. Tìm kiếm theo giá sản phẩm (nhỏ hơn).");
        System.out.println("0. Quay lại.");
    }

    public static void userCartView() {
        System.out.println("---------- Người dùng -> Giỏ hàng ----------");
        System.out.println("1. Hiển thị giỏ hàng.");
        System.out.println("2. Xoá sản phẩm khỏi giỏ hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void userOrderView() {
        System.out.println("---------- Người dùng -> Đặt hàng ----------");
        System.out.println("1. Hiển thị giỏ hàng.");
        System.out.println("2. Hiển thị đơn hàng đã đặt.");
        System.out.println("0. Quay lại.");
    }

    public static void addToOrderView() {
        System.out.println("---------- Người dùng -> Đặt hàng ----------");
        System.out.println("1. Đặt hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void addToCartView() {
        System.out.println("---------- Người dùng -> Giỏ hàng ----------");
        System.out.println("1. Thêm sản phẩm vào giỏ hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void adminView() {
        System.out.println("---------- Quản trị viên ----------");
        System.out.println("1. Quản lý người dùng.");
        System.out.println("2. Quản lý sản phẩm.");
        System.out.println("3. Quản lý đơn hàng.");
        System.out.println("0. Đăng xuất.");
    }

    public static void userManagerView() {
        System.out.println("---------- Quản trị viên -> Quản lý người dùng ----------");
        System.out.println("1. Hiển thị danh sách User.");
        System.out.println("2. Tìm kiếm User.");
        System.out.println("3. Xoá User.");
        System.out.println("4. Mở lại User.");
        System.out.println("0. Quay lại.");
    }

    public static void listUsersView() {
        System.out.println("---------- Quản trị viên -> Quản lý người dùng -> Hiển thị danh sách User ----------");
        System.out.println("1. Hiển thị tất cả User.");
        System.out.println("2. Hiển thị User Active.");
        System.out.println("3. Hiển thị User NonActive.");
        System.out.println("0. Quay lại.");
    }

    public static void productManagerView() {
        System.out.println("---------- Quản trị viên -> Quản lý sản phẩm ----------");
        System.out.println("1. Thêm mới sản phẩm.");
        System.out.println("2. Thêm mới danh mục.");
        System.out.println("3. Sửa đổi sản phẩm.");
        System.out.println("4. Sửa đổi danh mục.");
        System.out.println("0. Quay lại.");
    }

    public static void orderManagerView() {
        System.out.println("---------- Quản trị viên -> Quản lý đơn hàng ----------");
        System.out.println("1. Hiển thị tất cả đơn hàng.");
        System.out.println("2. Hiển thị danh sách đơn hàng chưa xác nhận.");
        System.out.println("3. Hiển thị danh sách đơn hàng đang vận chuyển.");
        System.out.println("4. Hiển thị danh sách đơn hàng đã hoàn thành.");
        System.out.println("5. Hiển thị danh sách đơn hàng đã huỷ.");
        System.out.println("0. Quay lại.");
    }

    public static void subOrderManagerView(String message) {
        System.out.println("---------- Quản trị viên -> Quản lý đơn hàng ----------");
        System.out.println("1. " + message + ".");
        System.out.println("2. Huỷ đơn hàng.");
        System.out.println("0. Quay lại.");
    }
}
