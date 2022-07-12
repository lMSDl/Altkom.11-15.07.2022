package mod09.ex01.calls;

public class PrepaidPhone {
	private int credit; // stan na karcie

	// starter
	public PrepaidPhone(int startCredit) {
		credit = startCredit;
	}

	// rozmowa telefoniczna
	public void makeCall(int min) {
		credit -= min; // zmniejszenie stanu na karcie
	}

	// zwraca stan na karcie
	public int getCredit() {
		return credit;
	}

	// doladowanie
	public void topUp(int min) {
		credit += min;
	}
}
