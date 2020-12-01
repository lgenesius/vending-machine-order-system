package adapter.yen;

public class YenCurrency implements Yen{

	@Override
	public double showInYen(int price) {
		double yen = (double) price / 142;
		return yen;
	}

}
