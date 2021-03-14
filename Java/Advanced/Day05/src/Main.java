import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0, second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.parseInt(parts[1]);

            switch(command) {
                case "add":
                    int add = first + amount;
                    if (add <= 100 && amount > 0) {
                        first += amount;
                    }
                    if (add > 100) {
                        first = 100;
                    }
                    break;
                case "move":
                    if (amount > 0) {
                        if (first - amount >= 0 && second + amount <= 100) {
                            first -= amount;
                            second += amount;
                        } else if (second + amount >= 100) {
                            int remain = 100 - second;
                            first -= remain;
                            second = 100;
                        } else {
                            amount = first;
                            first = 0;
                            second += amount;
                        }
                    }
                    break;
                case "remove":
                    if (second - amount >= 0 && amount > 0) {
                        second -= amount;
                    } else if (second - amount < 0) {
                        second = 0;
                    }

                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }
}
