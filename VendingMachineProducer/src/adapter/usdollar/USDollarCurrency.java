package adapter.usdollar;

public class USDollarCurrency implements USDollar {

	@Override
	public double showInDollar(int price) {
		double dollar = (double)price/16000;
		return dollar;
	}

}
