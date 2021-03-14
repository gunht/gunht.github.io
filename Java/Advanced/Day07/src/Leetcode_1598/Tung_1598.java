package Leetcode_1598;

public class Tung_1598 {
    public static void main(String[] args) {
//        String[] logs = {"d1/","d2/","../","d21/","./"};
//        String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs = {"d1/","../","../","../"};
        System.out.println(minOperations(logs));
    }
    public static int minOperations(String[] logs) {
        int result = 0;
        for (String log : logs) {
            switch (log) {
                case "../":
                    if (result > 0) {
                        result--;
                    }
                    break;
                case "./":
                    break;
                default:
                    result++;
            }
        }
        return result;
    }
}
