package java_project.Utils;

import java.util.Scanner;

public class ScannerUtil {
    public int checkInteger(Scanner scanner, String message, String error) {
        while (true) {
            try {
                System.out.println(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
}
