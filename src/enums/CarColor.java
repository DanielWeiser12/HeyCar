package enums;

import java.util.Arrays;
import java.util.Optional;

public enum CarColor {


	YELLOW("Gelb"), RED("Rot"), GREEN("Grün"), BLUE("Blau"), GRAY("Grau"), CYAN("Cyan"), BLACK("Schwarz"), WHITE("Weiss"), MAGENTA("Magenta");

	private String color;

	private CarColor(String color) {
		this.color = color;
	}

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
