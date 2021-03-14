package java_project.manager;

import java_project.Utils.IdUtil;
import java_project.Utils.ScannerUtil;
import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.AbstractId;
import java_project.entity.Category;
import java_project.entity.Product;
import java_project.service.ICategoryService;
import java_project.service.IProductService;
import java_project.service.Impl.CategoryService;
import java_project.service.Impl.ProductService;

import java.util.List;
import java.util.Scanner;

public class CategoryManager {
    private final ICategoryService categoryService;
    private final Scanner scanner;
    private final ScannerUtil scannerUtil;

    public CategoryManager() {
        categoryService = new CategoryService();
        scanner = new Scanner(System.in);
        scannerUtil = new ScannerUtil();
    }

    public void showCategory() {
        for (Category category : categoryService.findAll()) {
            System.out.println(category.toString());
        }
        System.out.println("0. Quay lại");
    }

    public void addCategory() {
        System.out.println("Nhập tên danh mục:");
        String name = scanner.nextLine();
        AbstractId.generateId = IdUtil.checkId(categoryService.findAll());
        Category category = categoryService.add(new Category(name));
        if (category == null) {
            System.out.println("Danh mục đã tồn tại!");
        } else {
            System.out.println("Đã tạo danh mục thành công!");
        }
    }

    public void updateCategory() {
        for (Category category : categoryService.findAll()) {
            System.out.println(category.toString());
        }
        int categoryId = scannerUtil.checkInteger(scanner, "Nhập id danh mục muốn sửa:", Constant.ERROR_MESSAGE);
        Category category = categoryService.findCategoryById((long) categoryId);
        if (category == null) {
            System.out.println("Danh mục không tồn tại!");
            return;
        }
        System.out.println("Nhập tên muốn sửa:");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            category.setName(name);
            System.out.println("Sửa tên danh mục thành công!");
        }
    }

    public List<Category> amountOfCategories() {
        return categoryService.findAll();
    }
}
