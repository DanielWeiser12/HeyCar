package enums;

public enum Transmission {

	MANUAL("Manual"), AUTOMATIC("Automatik");

	String transmission;

	private Transmission(String transmission) {
		this.transmission = transmission;
	}

	@Override
	public String toString() {
		return this.transmission;
	}

}
