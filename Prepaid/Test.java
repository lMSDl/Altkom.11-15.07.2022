package mod09.ex01.calls;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		final int NUMBER_OF_TOP_UPS = 3; // liczba doladowan
		Random r = new Random();
		boolean stop = false;
		int topUp = 0;

		PrepaidPhone pp = new PrepaidPhone(10);

		while (!stop) {

				System.out.println("Current credit: " + pp.getCredit());
				int callTime = r.nextInt(5) + 1;
                                if(pp.getCredit() < callTime)
                                {
				   pp.topUp(10 - pp.getCredit()); // doladowanie do 10 min
				   stop = ++topUp == NUMBER_OF_TOP_UPS;
                                }
                                pp.makeCall(callTime);

		}
		System.out.println("Current limit: " + pp.getCredit());
	}
}