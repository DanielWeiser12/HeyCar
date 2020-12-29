package enums;

import java.util.Arrays;
import java.util.Optional;

public enum Transmission {

	MANUAL("Manual"), AUTOMATIC("Automatik");

	String transmission;

	private Transmission(String transmission) {
		this.transmission = transmission;
	}

	public static Transmission getTransmissionOf(String name) {
		Optional<Transmission> transmission = Arrays.stream(Transmission.values())
				.filter(transm -> transm.toString().equals(name)).findFirst();
		if (transmission.isPresent()) {
			return transmission.get();
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return this.transmission;
	}

}
