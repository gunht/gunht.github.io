package java_project.Utils;

import java_project.entity.Product;

import java.util.Collections;
import java.util.Comparator;

public class SortProductByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() - o2.getPrice() == 0) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
        return o1.getPrice() - o2.getPrice();
    }
}
