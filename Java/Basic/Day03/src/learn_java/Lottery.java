package learn_java;

import java.util.Scanner;

public class Lottery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        final int maxNumber = 9999;
        final int minNumber = 10;
        int prizePool = 0;

        int randomNumber = (int)(Math.random() * (maxNumber - minNumber + 1)) + minNumber;

        System.out.print("Nhập 4 số bạn chọn: ");
        int numberCus = sc.nextInt();

        String numbCus = Integer.toString(numberCus);
        String randomNum = Integer.toString(randomNumber);

        if(numbCus.equals(randomNum)) {
            prizePool = 10_000;
        } else if(randomNum.indexOf(numbCus.substring(2,4)) != -1) {
            prizePool = 3_000;
        } else if(randomNum.indexOf(numbCus.substring(3,4)) != -1) {
            prizePool = 1_000;
        }

        System.out.println(prizePool);
    }
}
