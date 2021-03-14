package learn_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

//        String salary = "100000";
//        int sal = Integer.parseInt(salary);
//        System.out.println(sal);

//        int x = 1;
//        int y = 1;
//        String x = "1";
//        String y = "1";
//        System.out.println(x == y);

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập số nguyên bất kỳ: ");
//        int number = sc.nextInt();
//
//        if(number % 5 == 0 && number % 3 == 0)
//            System.out.print("FizzBuzz");
//         else if(number % 3 == 0)
//            System.out.println("Buzz");
//         else if(number % 5 == 0)
//            System.out.println("Fizz");
//         else
//            System.out.println(number);


//        String[] fruit = {"Hello", "Xoai", "Cam", "Tao", "Kem", "Oi",};
//
//        for(String index: fruit) {
//            System.out.println(index);
//        }

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int tienVay = 0;

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Số tiền vay: ");
            tienVay = sc.nextInt();
            if(tienVay >= 1000 && tienVay <= 1000000) 
                break;
                System.out.println("Tiền vay phải lớn hơn 1 nghìn và nhỏ hơn 1 triệu");
        }

        System.out.println("Lãi suất(%) hàng năm ");
        System.out.print("(Chỉ nhập số): ");
        double laiSuat = sc.nextDouble() / PERCENT;
        System.out.print("Kỳ hạn vay(năm): ");
        int kyHanVay = sc.nextInt() * MONTHS_IN_YEAR;
        double laiSuatThang = laiSuat / MONTHS_IN_YEAR;
        double tienLaiHangThang = tienVay * (
                (laiSuatThang * Math.pow(1 + laiSuatThang, kyHanVay)) / (Math.pow(1 + laiSuatThang, kyHanVay) - 1)
        );
        System.out.println("Số tiền lãi phải trả hàng tháng là: " + Math.round(tienLaiHangThang) + " đ");
        System.out.println("Tổng số tiền phải trả: " + Math.round(tienLaiHangThang) * kyHanVay + " đ");

    }
}