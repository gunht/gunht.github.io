package java_project.repository;

import java_project.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findCategoryById(Long id);
    Category add(Category category);
}
