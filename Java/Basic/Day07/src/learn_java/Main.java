package learn_java;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        var str = new GenericList<Integer>(2);
//        str.add(1);
//        str.add(2);
//
//        System.out.println(str);

        var keyValue = new KeyValuePair<String, Integer>("Hello", 20);
        var keyValue1 = new KeyValuePair<String, String>("Hello", "How");

        Utilities.printUser("ID", 1000);
    }
}
