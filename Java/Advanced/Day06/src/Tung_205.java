import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tung_205 {
    public static void main(String[] args) {
//        String s = "ab", t = "aa";
//        String s = "foo", t = "bar";
        String s = "paper", t = "title";
//        String s = "egg", t = "add";
//        String s = "", t = "";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && map.get(c) != t.charAt(i)) {
                return false;
            }
            map.put(c, t.charAt(i++));
        }
        int j = 0;
        for (char c : t.toCharArray()) {
            if (map2.containsKey(c) && map2.get(c) != s.charAt(j)) {
                return false;
            }
            map2.put(c, s.charAt(j++));
        }
        return true;
    }
}
