import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int triples = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i + 2] - arr[i] == 2) {
                triples++;
            }
        }

        System.out.println(triples);
    }
}