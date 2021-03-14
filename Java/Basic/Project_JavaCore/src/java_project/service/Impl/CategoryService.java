package java_project.service.Impl;

import java_project.entity.Category;
import java_project.repository.ICategoryRepository;
import java_project.repository.Impl.CategoryRepository;
import java_project.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public Category add(Category category) {
        return categoryRepository.add(category);
    }

}
