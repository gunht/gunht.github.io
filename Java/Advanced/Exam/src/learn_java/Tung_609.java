package learn_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tung_609 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        List<Integer> room = new ArrayList<>();
        List<List<Integer>> rr = new ArrayList<>();

        room.add(1);
        room.add(2);

        rr.add(room);

        for (int i : rr.get(0)) {
            set.add(i);
        }
        for (int i : set) {
            System.out.println(i);
        }
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < rooms.size(); i++) {
            for (int j : rooms.get(i)) {
                set.add(j);
            }
        }
        if (set.size() == rooms.size()) {
            return true;
        }
        return false;
    }
}
