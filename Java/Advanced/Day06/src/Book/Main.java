package Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(18967, "Book 18967"));
        books.add(new Book(978422, "Book 978422"));
//        books.add(new Book(2, "Book 2"));
//        books.add(new Book(3, "Book 3"));
//        books.add(new Book(4, "Book 4"));
//        books.add(new Book(5, "Book 5"));
//        books.add(new Book(6, "Book 6"));
//        books.add(new Book(7, "Book 7"));
//        books.add(new Book(8, "Book 8"));
//        books.add(new Book(9, "Book 9"));
//        books.add(new Book(10, "Book 10"));

        System.out.println(bSearch(books, 978422));
    }

    public static int bSearch(ArrayList<Book> books, int searchId) {
        if (books.size() <= 1) {
            return books.size() - 1;
        }
        int L = 0, R = books.size() - 1;

        while (L <= R) {
            int mid = (L + R)/2;
            if (books.get(mid).getId() == searchId) {
                return mid;
            }
            if (books.get(mid).getId() < searchId) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return -1;
    }
}
