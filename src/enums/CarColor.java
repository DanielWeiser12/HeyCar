package enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * This is an enum for the colors of the cars.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public enum CarColor {


	YELLOW("Gelb"), RED("Rot"), GREEN("Grün"), BLUE("Blau"), GRAY("Grau"), CYAN("Cyan"), BLACK("Schwarz"), WHITE("Weiss"), MAGENTA("Magenta");

	private String color;

	private CarColor(String color) {
		this.color = color;
	}

	/**
	 * A method to get an enum property from the color-string of the database.
	 * 
	 * @param name the string of the car color from the database
	 * @return the property of the enum
	 */

	public static CarColor getCarColorOf(String name) {
		Optional<CarColor> colorEnum = Arrays.stream(CarColor.values())
				.filter(eEnum -> eEnum.toString().equalsIgnoreCase(name))
				.findFirst();
		if (colorEnum.isPresent()) {
			return colorEnum.get();
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return this.color;
	}

}
