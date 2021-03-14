package java_project.service;

import java_project.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> findProductByCategoryId(long id);
    List<Product> findByName(String name);
    List<Product> findByPrice(int price, String option);
    Product findProductById(long id);
    Product findProductByIdAndCategoryId(long productId, long categoryId);
    Product saveProduct(Product product);
    Product updateProduct(int index, Product product);
}
