package learn_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void userSort() {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 3, 2, 5);

        List<User> users = new ArrayList<>();
        users.add(new User("Nam", 10, 170));
        users.add(new User("Thanh",9, 160));

//        Collections.sort(numbers);
//        System.out.println(numbers);

//        Collections.sort(users);
        Collections.sort(users, new HeightCompare());
        System.out.println(users);
    }
}
