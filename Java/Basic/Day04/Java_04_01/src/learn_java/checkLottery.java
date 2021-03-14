package learn_java;

public class checkLottery {
    private  char lotteryDigit1;
    private char lotteryDigit2;
    private char customerDigit1;
    private char customerDigit2;

    public String getAward(String lotteryNumber, String customerNumber) {
        lotteryDigit1 = lotteryNumber.charAt(0);
        lotteryDigit2 = lotteryNumber.charAt(1);
        customerDigit1 = customerNumber.charAt(0);
        customerDigit2 = customerNumber.charAt(1);

        if (lotteryNumber.equals(customerNumber))
            return "Giai dac biet";
        else if (lotteryDigit1 == customerDigit1
                && lotteryDigit2 == customerDigit1)
            return "Giai nhat";
        else if (lotteryDigit1 == customerDigit1
                || lotteryDigit1 == customerDigit2
                || lotteryDigit2 == customerDigit1
                || lotteryDigit2 == customerDigit2)
            return "Giai khuyen khich";
        else
            return "Khong co giai";
    }
}
