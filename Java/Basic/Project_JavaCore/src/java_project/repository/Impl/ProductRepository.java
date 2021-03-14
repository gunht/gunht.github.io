package java_project.repository.Impl;

import java_project.constant.Constant;
import java_project.data.CreateData;
import java_project.entity.Category;
import java_project.entity.Product;
import java_project.repository.ICategoryRepository;
import java_project.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends DataRepository<Product> implements IProductRepository {
    private final ICategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Product> findAll() {
        return CreateData.products;
    }

    @Override
    public List<Product> findProductByCategoryId(long id) {
        List<Product> products = new ArrayList<>();
        for (Product product : CreateData.products) {
            if (product.getCategoryId() == id) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> newList = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(name)) {
                newList.add(product);
            }
        }
        if (newList.size() == 0) {
            for (Product product : findAll()) {
                if (product.getCategory().getName().toLowerCase().contains(name)) {
                    newList.add(product);
                }
            }
        }
        return newList;
    }

    @Override
    public List<Product> findByPrice(int price, String option) {
        List<Product> newList = new ArrayList<>();
        if (option.equals(Constant.BIGGER_PRICE)) {
            for (Product product : findAll()) {
                if (product.getPrice() >= price) {
                    newList.add(product);
                }
            }
        } else {
            for (Product product : findAll()) {
                if (product.getPrice() <= price) {
                    newList.add(product);
                }
            }
        }
        return newList;
    }

    @Override
    public Product findProductById(long id) {
        for (Product product : CreateData.products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findProductByIdAndCategoryId(long productId, long categoryId) {
        for (Product product : findProductByCategoryId(categoryId)) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        for (Product product1 : findAll()) {
            if (product1.getName().toLowerCase().equals(product.getName().toLowerCase())) {
                return null;
            }
        }
        product.setCategory(categoryRepository.findCategoryById(product.getCategoryId()));
        return add(CreateData.products, product);
    }

    @Override
    public Product updateProduct(int index, Product product) {
        return findAll().set(index, product);
    }
}
