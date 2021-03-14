import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int num : arr) {
            if (num < minNumber) {
                minNumber = num;
            }
        }
        System.out.println(minNumber);
    }
}