import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tung_136 {
    public static void main(String[] args) {
//        int[] nums = {2,2,1};
        int[] nums = {4,1,2,1,2,3,4};
//        int[] nums = {1};
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                result = e.getKey();
            }
        }
        return result;
    }

    public static int singleNumber2(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            if (!mySet.contains(num)) {
                mySet.add(num);
            } else {
                mySet.remove(num);
            }
        }
        return mySet.hashCode();
    }
}
