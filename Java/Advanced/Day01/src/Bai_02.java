import java.util.Calendar;
import java.util.Scanner;

public class Bai_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Y1 = scan.nextInt();
        int M1 = scan.nextInt();
        int D1 = scan.nextInt();
        int Y2 = scan.nextInt();
        int M2 = scan.nextInt();
        int D2 = scan.nextInt();
        int X = scan.nextInt();

        int n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            int year = scan.nextInt();
            int month = scan.nextInt();
            int day = scan.nextInt();

        }

        System.out.println(Y1 + " " + M1 + " " + D1 + " - " + Y2 + " " + M2 + " " + D2 + " - " + X);
    }

    public static void checkDate(int year, int month, int day, int X) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);


    }
}
