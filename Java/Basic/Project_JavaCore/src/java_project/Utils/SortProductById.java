package java_project.Utils;

import java_project.entity.Product;

import java.util.Comparator;

public class SortProductById implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
