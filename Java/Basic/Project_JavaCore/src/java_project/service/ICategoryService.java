package java_project.service;

import java_project.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findCategoryById(Long id);
    Category add(Category category);
}
