package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String str = scanner.nextLine();

        System.out.println("---------");
        System.out.println("| " + str.charAt(0) + " " + str.charAt(1) + " " + str.charAt(2) + " |");
        System.out.println("| " + str.charAt(3) + " " + str.charAt(4) + " " + str.charAt(5) + " |");
        System.out.println("| " + str.charAt(6) + " " + str.charAt(7) + " " + str.charAt(8) + " |");
        System.out.println("---------");
    }
}
