package learn_java;

import java.util.*;

public class Leetcode_690 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        List<Integer> id1 = new ArrayList<>();
        List<Integer> id2 = new ArrayList<>();
        List<Integer> id3 = new ArrayList<>();
        id1.add(2);
        id1.add(3);
        employeeList.add(new Employee(1,5, id1));
        employeeList.add(new Employee(2,3, id2));
        employeeList.add(new Employee(3,3, id3));

        System.out.println(getImportance(employeeList, 1));
    }
    static Map<Integer, Employee> map = new HashMap<>();
    static int totalImportant = 0;

    public static int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        DFS(id);
        return totalImportant;
    }

    public static void DFS(int id) {
        Employee curEmployee = map.get(id);
        if (curEmployee == null) {
            return;
        }
        totalImportant += curEmployee.importance;
        for (Integer idCapduoi : curEmployee.subordinates) {
            DFS(idCapduoi);
        }
    }

//    public static int getImportance(List<Employee> employees, int id) {
//        /*
//        * */
//        if (employees.size() == 0) {
//            return 0;
//        }
//
//        return DFS(employees, id, 0);
//    }
//
//    public static int DFS(List<Employee> employees, int id, int sum) {
//        if (employees.size() == 0) {
//            return employees.get(id).importance;
//        }
//        sum += employees.get(id - 1).importance;
//
//        return sum;
//    }
}
