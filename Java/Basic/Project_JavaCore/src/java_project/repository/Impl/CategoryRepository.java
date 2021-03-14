package java_project.repository.Impl;

import java_project.data.CreateData;
import java_project.entity.Category;
import java_project.repository.ICategoryRepository;

import java.util.List;

public class CategoryRepository extends DataRepository<Category> implements ICategoryRepository {
    @Override
    public List<Category> findAll() {
        return CreateData.categories;
    }

    @Override
    public Category findCategoryById(Long id) {
        for (Category category : CreateData.categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category add(Category category) {
        for (Category category1 : CreateData.categories) {
            if (category1.getName().equals(category.getName())) {
                return null;
            }
        }
        return add(CreateData.categories, category);
    }
}
