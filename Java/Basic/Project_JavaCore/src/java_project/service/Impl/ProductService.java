package java_project.service.Impl;

import java_project.entity.Product;
import java_project.repository.IProductRepository;
import java_project.repository.Impl.ProductRepository;
import java_project.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductByCategoryId(long id) {
        return productRepository.findProductByCategoryId(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByPrice(int price, String option) {
        return productRepository.findByPrice(price, option);
    }

    @Override
    public Product findProductById(long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product findProductByIdAndCategoryId(long productId, long categoryId) {
        return productRepository.findProductByIdAndCategoryId(productId, categoryId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public Product updateProduct(int index, Product product) {
        return productRepository.updateProduct(index, product);
    }
}
