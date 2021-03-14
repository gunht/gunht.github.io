package learn_java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Số tiền vay: ");
        int tienVay = sc.nextInt();
        System.out.println("Lãi suất(%) hàng năm ");
        System.out.print("(Chỉ nhập số): ");
        double laiSuat = sc.nextDouble() / 100;
        System.out.print("Kỳ hạn vay(năm): ");
        int kyHanVay = sc.nextInt() * 12;
        double laiSuatThang = laiSuat / 12;
        double tinhLai = tienVay * (
                (laiSuatThang * Math.pow(1 + laiSuatThang, kyHanVay)) / (Math.pow(1 + laiSuatThang, kyHanVay) - 1)
                );
        System.out.println("Số tiền lãi phải trả hàng tháng là: " + Math.round(tinhLai) + " đ");
        System.out.println("Tổng số tiền phải trả: " + Math.round(tinhLai) * 60  + " đ");
    }
}

