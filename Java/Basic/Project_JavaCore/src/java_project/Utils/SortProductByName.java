package java_project.Utils;

import java_project.entity.Product;

import java.util.Comparator;

public class SortProductByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) == 0) {
            return o1.getPrice() - o2.getPrice();
        }
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}
