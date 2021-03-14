package learn_java;

import java.util.Scanner;

public class Ticket {
    private String lotteryNumber;
    private String customerNumber;

    public String getLotteryNumber() {
        lotteryNumber =
                "" + (int)(Math.random()*10) + (int)(Math.random()*10);
        return lotteryNumber;
    }

    public String getCustomerNumber() {
        System.out.print("Nhap vao ma so cua ticket: ");
        Scanner input = new Scanner(System.in);
        customerNumber = input.nextLine();
        return customerNumber;
    }

    public void printLotteryNumber() {
        System.out.println(lotteryNumber);
    }
}
