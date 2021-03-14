package learn_java;

public class Bai_04 {
     static public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()){
            count[c]++;
        }
        int sum = 0;
        boolean t = false;
        for (int count1 : count){
            if (count1 % 2 != 0){
                sum += count1 - 1;
                t = true;
            }else {
                sum += count1;
            }
        }
        return t ? sum + 1 : sum;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(s);
    }
}
