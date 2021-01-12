package enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * This is an enum for the transmission of the cars.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public enum Transmission {

	MANUAL("Manual"), AUTOMATIC("Automatik");

	String transmission;

	private Transmission(String transmission) {
		this.transmission = transmission;
	}

	/**
	 * A method to get an enum property from the transmission-string of the
	 * database.
	 * 
	 * @param name the string of the car transmission from the database
	 * @return the property of the enum
	 */

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
