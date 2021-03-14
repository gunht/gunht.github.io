package learn_java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1,2,3,1};
//        boolean valid = containsDuplicate(arr);
        containsDuplicate(arr);
    }

//    public static boolean containsDuplicate(int[] nums) {
//        Set<Integer> mySet = new HashSet<>();
//        for (int num : nums) {
//            if (!mySet.contains(num)) {
//                mySet.add(num);
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void containsDuplicate(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int num : nums) {
            if (!myMap.containsKey(num)) {
                myMap.put(num, 1);
            } else {
                myMap.put(num, myMap.get(num) + 1);
            }
        }

        for (Map.Entry e : myMap.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
