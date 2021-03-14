package learn_java;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var input = new Ticket();
    var lotteryNumber = input.getLotteryNumber();
    var customerNumber = input.getCustomerNumber();

        var checkLottery = new checkLottery();
    var award = checkLottery.getAward(lotteryNumber, customerNumber);
    input.printLotteryNumber();

    var annouceAward = new AnnouceAward();
    annouceAward.annouceAward(award);
    }
}
