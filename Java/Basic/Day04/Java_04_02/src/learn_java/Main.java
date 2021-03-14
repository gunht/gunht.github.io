package learn_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String lotteryNumber =
                "" + (int)(Math.random()*10) + (int)(Math.random()*10);
        System.out.println("So Lottery: " + lotteryNumber);
        System.out.print("Nhap vao ma so cua ticket: ");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();

        char lotteryDigit1 = lotteryNumber.charAt(0);
        char lotteryDigit2 = lotteryNumber.charAt(1);
        char numberDigit1 = number.charAt(0);
        char numberDigit2 = number.charAt(1);

        if (lotteryNumber.equals(number))
            System.out.println("Giai dac biet");
        else if (lotteryDigit1 == numberDigit2
                && lotteryDigit2 == numberDigit1)
            System.out.println("Giai nhat");
        else if (lotteryDigit1 == numberDigit1
                || lotteryDigit1 == numberDigit2
                || lotteryDigit2 == numberDigit1
                || lotteryDigit2 == numberDigit2
        )
            System.out.println("Giai khuyen khich");
        else
            System.out.println("Khong co giai");
    }
}
